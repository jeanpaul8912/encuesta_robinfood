package com.robinfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the encuesta_resultado database table.
 * 
 */
@Entity
@Table(name="encuesta_resultado")
@NamedQuery(name="EncuestaResultado.findAll", query="SELECT e FROM EncuestaResultado e")
public class EncuestaResultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp fechahora;

	//bi-directional many-to-one association to DetalleResultado
	@OneToMany(mappedBy="encuestaResultado")
	private List<DetalleResultado> detalleResultados;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Encuesta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_encuesta")
	private Encuesta encuesta;

	//bi-directional many-to-one association to EstadoEncuesta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estado_encuesta")
	private EstadoEncuesta estadoEncuesta;

	public EncuestaResultado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Timestamp fechahora) {
		this.fechahora = fechahora;
	}

	public List<DetalleResultado> getDetalleResultados() {
		return this.detalleResultados;
	}

	public void setDetalleResultados(List<DetalleResultado> detalleResultados) {
		this.detalleResultados = detalleResultados;
	}

	public DetalleResultado addDetalleResultado(DetalleResultado detalleResultado) {
		getDetalleResultados().add(detalleResultado);
		detalleResultado.setEncuestaResultado(this);

		return detalleResultado;
	}

	public DetalleResultado removeDetalleResultado(DetalleResultado detalleResultado) {
		getDetalleResultados().remove(detalleResultado);
		detalleResultado.setEncuestaResultado(null);

		return detalleResultado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Encuesta getEncuesta() {
		return this.encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public EstadoEncuesta getEstadoEncuesta() {
		return this.estadoEncuesta;
	}

	public void setEstadoEncuesta(EstadoEncuesta estadoEncuesta) {
		this.estadoEncuesta = estadoEncuesta;
	}

}