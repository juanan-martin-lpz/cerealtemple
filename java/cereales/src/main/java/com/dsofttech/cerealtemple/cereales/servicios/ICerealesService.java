package com.dsofttech.cerealtemple.cereales.servicios;

import java.util.List;

import com.dsofttech.cerealtemple.cereales.entidades.Cereal;


public interface ICerealesService {
	
	public List<Cereal> obtenerTodos();
	public Cereal obtenerPorId(long id);
	
	public List<Cereal> obtenerPorTipo(long tipo);
	
	public Cereal nuevo(Cereal cereal);
	public void borrar(long id);
	public Cereal modificar(long id, Cereal cereal);

}
