package com.propia.sgdm.service.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
@AllArgsConstructor
public class EstanteriaBean extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = -5876548156701564108L;
	@JsonProperty("indent")
	private String ident;
	@JsonProperty("nombre")
	private String nombre;

	
	public EstanteriaBean() {}
	
	
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
