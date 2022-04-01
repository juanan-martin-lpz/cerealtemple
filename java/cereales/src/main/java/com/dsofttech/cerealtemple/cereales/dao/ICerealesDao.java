package com.dsofttech.cerealtemple.cereales.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsofttech.cerealtemple.cereales.entidades.Cereal;

public interface ICerealesDao extends JpaRepository<Cereal, Long> {

	public List<Cereal> findByprecio(Cereal c);
	
}
