package com.dsofttech.cerealtemple.mantenimientos.servicios;

import java.util.List;

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
	public void borrar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color modificar(long id, Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color obtenerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.dao.findBynombre(nombre);
	}



}
