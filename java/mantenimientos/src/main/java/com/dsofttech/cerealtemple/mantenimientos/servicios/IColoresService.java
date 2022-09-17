package com.dsofttech.cerealtemple.mantenimientos.servicios;

import java.util.List;

import com.dsofttech.cerealtemple.mantenimientos.entidades.Color;


public interface IColoresService {

	public List<Color> obtenerTodos();
	public Color obtenerPorId(long id);
	public Color obtenerPorNombre(String nombre);
	
	public Color nuevo(Color color);
	public Color borrar(long id);
	public Color modificar(long id, Color color);

}
