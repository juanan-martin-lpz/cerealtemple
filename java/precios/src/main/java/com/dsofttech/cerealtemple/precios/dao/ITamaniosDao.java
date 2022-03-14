package com.dsofttech.cerealtemple.precios.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dsofttech.cerealtemple.precios.entidades.Tamanio;

public interface ITamaniosDao extends JpaRepository<Tamanio, Integer> {

}
