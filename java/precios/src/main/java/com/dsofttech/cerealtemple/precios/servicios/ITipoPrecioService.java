package com.dsofttech.cerealtemple.precios.servicios;

import java.util.List;

import com.dsofttech.cerealtemple.precios.entidades.Precio;


public interface ITipoPrecioService {

	public List<Precio> obtenerTodos();
	public Precio obtenerPorId(long id);
	
	public Precio nuevo(Precio tipo);
	public void borrar(long id);
	public Precio modificar(long id, Precio precio);
	
}
