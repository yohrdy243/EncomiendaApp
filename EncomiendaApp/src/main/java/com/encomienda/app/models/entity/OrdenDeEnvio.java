package com.encomienda.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class OrdenDeEnvio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idOrdenDePedido;
	
	@Column(name = "clave")
	private String clave;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "fecha_envio")
	private Date fecha_envio;
	
	@Column(name= "precio_total")
	private float precio_total;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_ruta_fk",referencedColumnName = "idRuta")
	private Ruta ruta;
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_paquetes_fk")
	private List<Paquete> paquetes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_clienteEmisor_fk",referencedColumnName = "idCliente")
	private Cliente ClienteEmisor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_clienteReceptor_fk",referencedColumnName = "idCliente")
	private Cliente ClienteReceptor;

	public float calcularPrecioTotal() {
		return 0;
	}
	public Long getIdOrdenDePedido() {
		return idOrdenDePedido;
	}

	public void setIdOrdenDePedido(Long idOrdenDePedido) {
		this.idOrdenDePedido = idOrdenDePedido;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public float getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(float precio_total) {
		this.precio_total = precio_total;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Cliente getClienteEmisor() {
		return ClienteEmisor;
	}

	public void setClienteEmisor(Cliente clienteEmisor) {
		ClienteEmisor = clienteEmisor;
	}

	public Cliente getClienteReceptor() {
		return ClienteReceptor;
	}

	public void setClienteReceptor(Cliente clienteReceptor) {
		ClienteReceptor = clienteReceptor;
	}
	
	
	

}
