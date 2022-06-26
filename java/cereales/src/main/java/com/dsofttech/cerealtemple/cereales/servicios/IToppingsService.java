package com.dsofttech.cerealtemple.cereales.servicios;

import java.util.List;

import com.dsofttech.cerealtemple.cereales.entidades.Toppings;


public interface IToppingsService {

	public List<Toppings> obtenerTodos();
	public Toppings obtenerPorId(long id);
	
	public Toppings nuevo(Toppings topping /*, MultipartFile archivo */);
	public void borrar(long id);
	public Toppings modificar(long id, Toppings topping /*, MultipartFile archivo */);

}
