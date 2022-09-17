package com.dsofttech.cerealtemple.mantenimientos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsofttech.cerealtemple.mantenimientos.dao.IColoresDao;
import com.dsofttech.cerealtemple.mantenimientos.entidades.Color;

@Service
public class ColoresService implements IColoresService {

	@Autowired
	private IColoresDao dao;
	
	
	@Override
	public List<Color> obtenerTodos() {
		
		return this.dao.findAll();	
	}

	@Override
	public Color obtenerPorId(long id) {
		return this.dao.getById(id);
	}

	@Override
	public Color nuevo(Color color) {
		return this.dao.save(color);
	}

	@Override
	public Color borrar(long id) {
		
		Color color = this.dao.getById(id);
		
		this.dao.deleteById(id);
		
		return color;
	}

	@Override
	public Color modificar(long id, Color color) {
		
		Optional<Color> op_co = this.dao.findById(id);
		
		if (op_co.isPresent()) {
			Color co = op_co.get();
			
			co.setNombre(color.getNombre());
			
			return this.dao.save(co);
			
		}
		else {
			return null;
		}
	}

	@Override
	public Color obtenerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.dao.findBynombre(nombre);
	}



}
