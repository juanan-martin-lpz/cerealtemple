package com.dsofttech.cerealtemple.mantenimientos.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsofttech.cerealtemple.mantenimientos.entidades.Precio;
import com.dsofttech.cerealtemple.mantenimientos.entidades.PrecioTamanio;

public interface IPrecioTamanioDao extends JpaRepository<PrecioTamanio, Long> {

	public List<PrecioTamanio> findBytipoprecio(Precio tipoprecio);

}
