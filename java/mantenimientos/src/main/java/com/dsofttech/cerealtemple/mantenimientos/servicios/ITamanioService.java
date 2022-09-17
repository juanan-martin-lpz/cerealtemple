package com.dsofttech.cerealtemple.mantenimientos.servicios;

import java.util.List;

import com.dsofttech.cerealtemple.mantenimientos.entidades.Tamanio;

public interface ITamanioService {

	public List<Tamanio> obtenerTodos();
	public Tamanio obtenerPorId(int id);
	
	public Tamanio nuevo(Tamanio precio);
	public Tamanio borrar(int id);
	public Tamanio modificar(int id, Tamanio tamanio);
	
}
