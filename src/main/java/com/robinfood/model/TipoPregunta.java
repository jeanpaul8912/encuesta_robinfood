package com.robinfood.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;


/**
 * The persistent class for the tipo_pregunta database table.
 * 
 */
@Entity
@Table(name="tipo_pregunta")
@NamedQuery(name="TipoPregunta.findAll", query="SELECT t FROM TipoPregunta t")
public class TipoPregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String codigo;

	private String descripcion;
	
	@OneToMany(mappedBy="tipoPregunta")

	@JsonBackReference
	private List<Pregunta> preguntas;

	public TipoPregunta() {
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
	
	
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
	public Pregunta addPregunta(Pregunta pregunta) {
		getPreguntas().add(pregunta);
		pregunta.setTipoPregunta(this);

		return pregunta;
	}

	public Pregunta removePregunta(Pregunta pregunta) {
		getPreguntas().remove(pregunta);
		pregunta.setTipoPregunta(null);

		return pregunta;
	}
	
	
	public List<Pregunta> getPreguntas() {
		return this.preguntas;
	}
}