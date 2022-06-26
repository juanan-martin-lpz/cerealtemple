package com.dsofttech.cerealtemple.cereales.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dsofttech.cerealtemple.cereales.entidades.Toppings;

public interface IToppingsDao extends JpaRepository<Toppings, Long> {

	
}