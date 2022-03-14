package com.dsofttech.cerealtemple.precios.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="PRECIOS_TAMANIOS")
@Data
@JsonIgnoreProperties("hibernateLazyInitializer")
public class PrecioTamanio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idprecio_tamanio;

	@OneToOne
	@JoinColumn(name="idprecio", referencedColumnName = "idprecio", nullable=false)
	private Precio tipoprecio;
	
	@OneToOne
	@JoinColumn(name = "idtamanio", referencedColumnName = "idtamanio", nullable=false)
	private Tamanio tamanio;
	
	private double precio;
	
	
}
