package com.dsofttech.cerealtemple.mantenimientos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsofttech.cerealtemple.mantenimientos.dao.ITamaniosDao;
import com.dsofttech.cerealtemple.mantenimientos.entidades.Tamanio;

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
		
		this.dao.deleteById(id);
		
	}

	@Override
	public Tamanio modificar(int id, Tamanio tamanio) {
		
		Optional<Tamanio> op_ta = this.dao.findById(id);
		
		if (op_ta.isPresent()) {
			Tamanio ta = op_ta.get();
			
			ta.setNombre(tamanio.getNombre());
			
			return this.dao.save(ta);
			
		}
		else {
			return null;
		}
	}


}
