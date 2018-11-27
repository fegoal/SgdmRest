package com.propia.sgdm.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name= "Articulos")
@AllArgsConstructor
public class ArticuloDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8163355831540135714L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@JsonProperty("nombre")
	private String nombre;
	@JsonProperty("modelo")
	private String modelo;
	@JsonProperty("pvp")
	private String pvp;
	@JsonProperty("validoDesde")
	private String validoDesde;
	@JsonProperty("validoHasta")
	private String validoHasta;
	
	@ManyToOne
	@JsonProperty("estanteria")
	private EstanteriaDto estanteria;
	
	public ArticuloDto() {}

	
//	public ArticuloDto(String nombre, String modelo, String pvp, String validoDesde, String validoHasta, EstanteriaDto estanteria) {
//		super();
//		this.nombre = nombre;
//		this.modelo = modelo;
//		this.pvp = pvp;
//		this.validoDesde = validoDesde;
//		this.validoHasta = validoHasta;
//		this.estanteria = estanteria;
//	}
//	
//	public ArticuloDto(String nombre, String modelo, String pvp, String validoDesde, String validoHasta) {
//		super();
//		this.nombre = nombre;
//		this.modelo = modelo;
//		this.pvp = pvp;
//		this.validoDesde = validoDesde;
//		this.validoHasta = validoHasta;
//	}
//	
//	
//	
//	public ArticuloDto(Integer id, String nombre, String modelo, String pvp, String validoDesde, String validoHasta) {
//		super();
//		this.id = id;
//		this.nombre = nombre;
//		this.modelo = modelo;
//		this.pvp = pvp;
//		this.validoDesde = validoDesde;
//		this.validoHasta = validoHasta;
//	}


	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPvp() {
		return pvp;
	}
	public void setPvp(String pvp) {
		this.pvp = pvp;
	}
	public String getValidoDesde() {
		return validoDesde;
	}
	public void setValidoDesde(String validoDesde) {
		this.validoDesde = validoDesde;
	}
	public String getValidoHasta() {
		return validoHasta;
	}
	public void setValidoHasta(String validoHasta) {
		this.validoHasta = validoHasta;
	}
	public EstanteriaDto getEstanteria() {
		return estanteria;
	}
	public void setEstanteria(EstanteriaDto estanteria) {
		this.estanteria = estanteria;
	}

	
	
	
	
}
