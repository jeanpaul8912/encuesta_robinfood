package com.robinfood.model;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;


/**
 * The persistent class for the restaurante database table.
 * 
 */
@Entity
@Table(name="restaurante")
@NamedQuery(name="Restaurante.findAll", query="SELECT r FROM Restaurante r")
public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Encuesta
	@OneToMany(mappedBy="restaurante")
	@JsonBackReference
	private List<Encuesta> encuestas;

	public Restaurante() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Encuesta> getEncuestas() {
		return this.encuestas;
	}

	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}

	public Encuesta addEncuesta(Encuesta encuesta) {
		getEncuestas().add(encuesta);
		encuesta.setRestaurante(this);

		return encuesta;
	}

	public Encuesta removeEncuesta(Encuesta encuesta) {
		getEncuestas().remove(encuesta);
		encuesta.setRestaurante(null);

		return encuesta;
	}

}