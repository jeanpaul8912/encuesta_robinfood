package com.robinfood.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

/**
 * The persistent class for the encuesta database table.
 * 
 */
@Entity
@Table(name="encuesta")
@NamedQuery(name="Encuesta.findAll", query="SELECT e FROM Encuesta e")
public class Encuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_encuesta")
	private int idEncuesta;

	private String codigo;

	private String descripcion;
	
	@OneToMany(mappedBy="encuesta")
	@JsonManagedReference
	private List<Pregunta> preguntas;

	//bi-directional many-to-one association to Restaurante
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_restaurante")
	@JsonBackReference
	private Restaurante restaurante;

	public Encuesta() {
	}

	public int getId() {
		return this.idEncuesta;
	}

	public void setId(int idEncuesta) {
		this.idEncuesta = idEncuesta;
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

	public Restaurante getRestaurante() {
		return this.restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setEncuesta(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setEncuesta(null);

		return pregunta;
	}

}