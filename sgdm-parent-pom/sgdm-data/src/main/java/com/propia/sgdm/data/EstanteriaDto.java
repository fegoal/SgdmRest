package com.propia.sgdm.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Estanterias")
public class EstanteriaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5876548156701564108L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@JsonProperty("nombre")
	private String nombre;

	public EstanteriaDto() {
	}
	
	public EstanteriaDto(String nombre) {
		super();
		this.nombre = nombre;
	}

	public EstanteriaDto(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
