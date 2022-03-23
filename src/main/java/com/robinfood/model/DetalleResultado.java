package com.robinfood.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="detalle_resultado")
@NamedQuery(name="DetalleResultado.findAll", query="SELECT d FROM DetalleResultado d")
public class DetalleResultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String pregunta;

	private String respuesta;

	//bi-directional many-to-one association to EncuestaResultado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_encuesta_resultado")
	private EncuestaResultado encuestaResultado;

	public DetalleResultado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public EncuestaResultado getEncuestaResultado() {
		return this.encuestaResultado;
	}

	public void setEncuestaResultado(EncuestaResultado encuestaResultado) {
		this.encuestaResultado = encuestaResultado;
	}

}