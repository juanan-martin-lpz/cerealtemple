package com.dsofttech.cerealtemple.precios.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsofttech.cerealtemple.precios.dao.ITamaniosDao;
import com.dsofttech.cerealtemple.precios.entidades.Tamanio;

@Service
public class TamanioService implements ITamanioService {

	@Autowired
	private ITamaniosDao dao;
	
	
	@Override
	public List<Tamanio> obtenerTodos() {
		
		return this.dao.findAll();	
	}

	@Override
	public Tamanio obtenerPorId(int id) {
		return this.dao.getById(id);
	}

	@Override
	public Tamanio nuevo(Tamanio tipo) {
		return this.dao.save(tipo);
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tamanio modificar(long id, Tamanio tamanio) {
		// TODO Auto-generated method stub
		return null;
	}


}
