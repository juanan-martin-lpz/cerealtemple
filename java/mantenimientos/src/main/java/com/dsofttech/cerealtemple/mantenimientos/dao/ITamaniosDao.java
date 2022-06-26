package com.dsofttech.cerealtemple.mantenimientos.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dsofttech.cerealtemple.mantenimientos.entidades.Tamanio;

public interface ITamaniosDao extends JpaRepository<Tamanio, Integer> {

}
