package com.dsofttech.cerealtemple.precios.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsofttech.cerealtemple.precios.dao.IPreciosDao;
import com.dsofttech.cerealtemple.precios.entidades.Precio;

@Service
public class TipoPrecioService implements ITipoPrecioService {

	@Autowired
	private IPreciosDao dao;
	
	@Override
	public List<Precio> obtenerTodos() {
		
		return this.dao.findAll();	
	}

	@Override
	public Precio obtenerPorId(long id) {
		return this.dao.getById(id);
	}

	@Override
	public Precio nuevo(Precio tipo) {
		return this.dao.save(tipo);
	}

	@Override
	public void borrar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Precio modificar(long id, Precio precio) {
		// TODO Auto-generated method stub
		return null;
	}

}
