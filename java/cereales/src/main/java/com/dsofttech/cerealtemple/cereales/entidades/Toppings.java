package com.dsofttech.cerealtemple.cereales.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="CEREALES")
@Data
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Toppings {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idtopping;

	@Column(length=30)
	private String nombre;
	
}
