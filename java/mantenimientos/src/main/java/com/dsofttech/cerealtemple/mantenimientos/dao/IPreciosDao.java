package com.dsofttech.cerealtemple.mantenimientos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dsofttech.cerealtemple.mantenimientos.entidades.Precio;

public interface IPreciosDao extends JpaRepository<Precio, Long> {
	

}
