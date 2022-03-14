package com.dsofttech.cerealtemple.precios.servicios;

import java.util.List;

import com.dsofttech.cerealtemple.precios.entidades.PrecioTamanio;

public interface IPrecioTamanioService {

	public List<PrecioTamanio> obtenerTodos();
	public PrecioTamanio obtenerPorId(long id);
	
	public List<PrecioTamanio> obtenerPorTipo(long tipo);
	
	public PrecioTamanio nuevo(PrecioTamanio precio);
	public void borrar(long id);
	public PrecioTamanio modificar(long id, PrecioTamanio precio);
	
}
