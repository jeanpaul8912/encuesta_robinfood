package com.robinfood.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the estado_encuesta database table.
 * 
 */
@Entity
@Table(name="estado_encuesta")
@NamedQuery(name="EstadoEncuesta.findAll", query="SELECT e FROM EstadoEncuesta e")
public class EstadoEncuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String codigo;

	private String descripcion;

	public EstadoEncuesta() {
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

}