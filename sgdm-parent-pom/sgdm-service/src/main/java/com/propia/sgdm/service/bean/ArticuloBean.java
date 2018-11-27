package com.propia.sgdm.service.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;

@ApiModel("ARTICULOS")
@AllArgsConstructor
@JsonPropertyOrder({ "ident", "nombre", "modelo", "pvp", "validoDesde","validoHasta","liks","estanteria" })
@JsonInclude(Include.NON_EMPTY)
public class ArticuloBean extends ResourceSupport implements Serializable {

	private static final long serialVersionUID = 8163355831540135714L;
	@JsonProperty("ident")
    @NotNull
	@ApiModelProperty(value = "the ARTICULO's id", required = true)
	private String ident;
	
	@ApiModelProperty(value = "the NOMBRE", required = true)
	@JsonProperty("nombre")
	private String nombre;
	
	@ApiModelProperty(value = "the MODELO", required = true)
	@JsonProperty("modelo")
	private String modelo;
	
	@ApiModelProperty(value = "the PVP", required = true)
	@JsonProperty("pvp")
	private String pvp;
	
	@ApiModelProperty(value = "AÑO VALIDO DESDE", required = true)
	@JsonProperty("validoDesde")
	private String validoDesde;
	
	@ApiModelProperty(value = "AÑO VALIDO HASTA", required = true)
	@JsonProperty("validoHasta")
	private String validoHasta;
	
	@ApiModelProperty(value = "the ESTANTERIA", required = false)
	private EstanteriaBean estanteria;

	public ArticuloBean() {}

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

	public EstanteriaBean getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(EstanteriaBean estanteria) {
		this.estanteria = estanteria;
	}
	


}
