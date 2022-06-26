package com.dsofttech.cerealtemple.cereales.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dsofttech.cerealtemple.cereales.dao.IToppingsDao;
import com.dsofttech.cerealtemple.cereales.entidades.Toppings;

public class ToppingsService implements IToppingsService {
	@Autowired
	private IToppingsDao dao;

	@Override
	public List<Toppings> obtenerTodos() {
		return this.dao.findAll();
	}

	@Override
	public Toppings obtenerPorId(long id) {
		return this.dao.getById(id);
	}


	@Override
	public Toppings nuevo(Toppings topping /*, MultipartFile archivo */) {
		
		/*
		try {
			cereal.setImagen(archivo.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		return this.dao.save(topping);
	}

	@Override
	public void borrar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Toppings modificar(long id, Toppings topping /*, MultipartFile archivo */) {
		
		Optional<Toppings> c = this.dao.findById(id);
		
		if (c.isPresent()) {
		
			Toppings top = c.get();
			top.setNombre(topping.getNombre());

			/*
			try {
				
				if (archivo != null) {
					cl.setImagen(archivo.getBytes());					
				}
								
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			return this.dao.save(top);
			
		}
		else {
			return null;
		}
	}
}
