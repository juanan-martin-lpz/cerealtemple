package com.dsofttech.cerealtemple.precios.servicios;

import java.util.List;

import com.dsofttech.cerealtemple.precios.entidades.Tamanio;

public interface ITamanioService {

	public List<Tamanio> obtenerTodos();
	public Tamanio obtenerPorId(int id);
	
	public Tamanio nuevo(Tamanio precio);
	public void borrar(int id);
	public Tamanio modificar(long id, Tamanio tamanio);
	
}
