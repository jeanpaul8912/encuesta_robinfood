package com.robinfood.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the opcion_respuesta database table.
 * 
 */
@Entity
@Table(name="opcion_respuesta")
@NamedQuery(name="OpcionRespuesta.findAll", query="SELECT o FROM OpcionRespuesta o")
public class OpcionRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String codigo;

	private String descripcion;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_pregunta")
	@JsonBackReference
	private Pregunta pregunta;

	public OpcionRespuesta() {
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

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

}