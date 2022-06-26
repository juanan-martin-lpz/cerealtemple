package com.dsofttech.cerealtemple.mantenimientos.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dsofttech.cerealtemple.mantenimientos.entidades.Color;

public interface IColoresDao extends JpaRepository<Color, Long> {
	
	public Color findBynombre(String nombre);

}
