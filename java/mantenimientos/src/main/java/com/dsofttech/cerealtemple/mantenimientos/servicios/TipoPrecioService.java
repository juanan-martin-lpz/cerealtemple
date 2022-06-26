package com.dsofttech.cerealtemple.mantenimientos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsofttech.cerealtemple.mantenimientos.dao.IPreciosDao;
import com.dsofttech.cerealtemple.mantenimientos.entidades.Precio;

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
		this.dao.deleteById(id);
	}

	@Override
	public Precio modificar(long id, Precio precio) {
		
		Optional<Precio> op_pr = this.dao.findById(id);
		
		if (op_pr.isPresent()) {
			Precio pr = op_pr.get();
			
			pr.setTipo_precio(precio.getTipo_precio());
			
			return this.dao.save(precio);
			
		}
		else {
			return null;
		}
	}

}
