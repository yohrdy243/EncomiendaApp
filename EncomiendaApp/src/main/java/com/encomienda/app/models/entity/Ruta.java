package com.encomienda.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Ruta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRuta;
	
	@Column(name = "precio")
	private float precio;
	
	@ManyToOne
	@JoinColumn(name = "ruta_sucursalEmisor_fk",referencedColumnName = "idSucursal",foreignKey = @ForeignKey(name = "ruta_sucursalEmisor_fk", value = ConstraintMode.CONSTRAINT))
	private Sucursal sucursalEmisor;
	
	@ManyToOne
	@JoinColumn(name = "ruta_sucursalReceptor_fk",referencedColumnName = "idSucursal",foreignKey = @ForeignKey(name = "ruta_sucursalReceptor_fk", value = ConstraintMode.CONSTRAINT))
	private Sucursal sucursalReceptor;
	

	public Long getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(Long idRuta) {
		this.idRuta = idRuta;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Sucursal getSucursalEmisor() {
		return sucursalEmisor;
	}

	public void setSucursalEmisor(Sucursal sucursalEmisor) {
		this.sucursalEmisor = sucursalEmisor;
	}

	public Sucursal getSucursalReceptor() {
		return sucursalReceptor;
	}

	public void setSucursalReceptor(Sucursal sucursalReceptor) {
		this.sucursalReceptor = sucursalReceptor;
	}
	
	

	
}
