package com.encomienda.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@Column(name = "costo")
	private float costo;
	
	@Column(name= "pesoMinimo")
	private float pesoMinimo;
	
	@Column(name= "pesoMaximo")
	private float pesoMaximo;
	
	@Column(name = "tipoCategoria")
	private char tipoCategoria;
	
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public float getPesoMinimo() {
		return pesoMinimo;
	}

	public void setPesoMinimo(float pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}

	public float getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(float pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public char getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(char tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}
	
}
