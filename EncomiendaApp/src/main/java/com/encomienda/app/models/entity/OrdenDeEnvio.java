package com.encomienda.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
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
	private Long idOrdenDeEnvio;
	
	@Column(name = "clave")
	private String clave;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "fecha_envio")
	private Date fechaEnvio;
	
	@Column(name= "precio_total")
	private float precioTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_ruta_fk",referencedColumnName = "idRuta",foreignKey = @ForeignKey(name = "orden_ruta_fk", value = ConstraintMode.CONSTRAINT))
	private Ruta ruta;
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_paquetes_fk")
	private List<Paquete> paquetes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_clienteEmisor_fk",referencedColumnName = "idCliente",foreignKey = @ForeignKey(name = "orden_clienteEmisor_fk", value = ConstraintMode.CONSTRAINT))
	private Cliente ClienteEmisor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_clienteReceptor_fk",referencedColumnName = "idCliente",foreignKey = @ForeignKey(name = "orden_clienteReceptor_fk", value = ConstraintMode.CONSTRAINT))
	private Cliente ClienteReceptor;

	public void calcularPrecioTotal() {
		
		this.precioTotal = 0;
		float precioPorCategoria = 0;
		float precioPorEnvio = ruta.getPrecio() * paquetes.size();
		
		for (Paquete paquete : paquetes) {
			precioPorCategoria = precioPorCategoria + paquete.getCategoria().getCosto();
		}
		
		this.precioTotal = precioPorCategoria + precioPorEnvio;
	}
	
	public Long getIdOrdenDeEnvio() {
		return idOrdenDeEnvio;
	}

	public void setIdOrdenDeEnvio(Long idOrdenDeEnvio) {
		this.idOrdenDeEnvio = idOrdenDeEnvio;
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

	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
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
