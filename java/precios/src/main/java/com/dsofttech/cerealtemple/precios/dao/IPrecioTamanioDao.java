package com.dsofttech.cerealtemple.precios.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsofttech.cerealtemple.precios.entidades.Precio;
import com.dsofttech.cerealtemple.precios.entidades.PrecioTamanio;

public interface IPrecioTamanioDao extends JpaRepository<PrecioTamanio, Long> {

	public List<PrecioTamanio> findBytipoprecio(Precio tipoprecio);

}
