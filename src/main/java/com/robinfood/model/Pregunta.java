package com.robinfood.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

/**
 * The persistent class for the pregunta database table.
 * 
 */
@Entity
@Table(name="pregunta")
@NamedQuery(name="Pregunta.findAll", query="SELECT p FROM Pregunta p")
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codigo;

	private String descripcion;
	
	@OneToMany(mappedBy="pregunta")
	@JsonManagedReference
	private List<OpcionRespuesta> opcionRespuestas;

	//bi-directional many-to-one association to Encuesta
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_encuesta")
	@JsonBackReference
	private Encuesta encuesta;
	
	@ManyToOne
	@JoinColumn(name="id_tipo")
	@JsonManagedReference
	private TipoPregunta tipoPregunta;

	public Pregunta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
	
	public TipoPregunta getTipoPregunta() {
		return this.tipoPregunta;
	}

	public void setTipoPregunta(TipoPregunta tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
}