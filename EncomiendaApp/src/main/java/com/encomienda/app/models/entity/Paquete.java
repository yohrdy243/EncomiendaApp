package com.encomienda.app.models.entity;

import java.io.Serializable;

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
import javax.persistence.Table;


@Entity
@Table
public class Paquete implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaquete;
	
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private boolean estado;
	
	@Column(name= "fragilidad")
	private boolean fragilidad;
	
	@Column(name = "peso")
	private float peso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paquete_categoria_fk", referencedColumnName = "idCategoria",foreignKey = @ForeignKey(name = "paquete_categoria_fk", value = ConstraintMode.CONSTRAINT))
	private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orden_paquetes_fk",referencedColumnName = "idOrdenDeEnvio",foreignKey = @ForeignKey(name = "paquete_orden_fk", value = ConstraintMode.CONSTRAINT))
	private OrdenDeEnvio ordenDeEnvio;
	
	public boolean validarEstadoVigente() 
	{
		if(estado == true) {
			return true;
		}else {
			return false;
		}
	}

	
	public boolean validarPesoDePaquete() {
		
		float pesoMaximo = this.categoria.getPesoMaximo();
		float pesoMinimo = this.categoria.getPesoMinimo();
		char categoria = this.categoria.getTipoCategoria();
		
		switch (categoria) {
			case 'A' : 
					if(this.peso >= pesoMaximo && this.peso >= pesoMinimo) {
							return true;
						}
					break;
			case 'B' : 
					if(this.peso >= pesoMaximo  && this.peso >= pesoMinimo) {
							return true;
						}
				break;
			case 'C' : 
					if(this.peso >= pesoMaximo  && this.peso >= pesoMinimo) {
							return true;
						}
				break;
			case 'D' : 
					if(this.peso >= pesoMaximo  && this.peso >= pesoMinimo) {
							return true;
						}
				break;
			case 'E' : 
					if(this.peso >= pesoMaximo  && this.peso >= pesoMinimo) {
							return true;
						}
				break;
				
			default:
				return false;
			}
		return false;
	}
	
	
	
	public Long getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(Long idPaquete) {
		this.idPaquete = idPaquete;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isFragilidad() {
		return fragilidad;
	}

	public void setFragilidad(boolean fragilidad) {
		this.fragilidad = fragilidad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
 
}
