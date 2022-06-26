package com.dsofttech.cerealtemple.mantenimientos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsofttech.cerealtemple.mantenimientos.dao.IPrecioTamanioDao;
import com.dsofttech.cerealtemple.mantenimientos.entidades.Precio;
import com.dsofttech.cerealtemple.mantenimientos.entidades.PrecioTamanio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PrecioTamanioService implements IPrecioTamanioService {

	private Logger log = LoggerFactory.getLogger(PrecioTamanioService.class);

	@Autowired
	private IPrecioTamanioDao dao;
	
	@Override
	public List<PrecioTamanio> obtenerTodos() {
		
		return this.dao.findAll();
		
	}

	@Override
	public PrecioTamanio obtenerPorId(long id) {
		// TODO: que hacer si no lo encuentra?
		return this.dao.getById(id);
		
	}

	@Override
	public List<PrecioTamanio> obtenerPorTipo(long tipo) {

		Precio p = new Precio();
		p.setIdprecio(tipo);
		
		return this.dao.findBytipoprecio(p);
	}

	@Override
	public PrecioTamanio nuevo(PrecioTamanio precio) {

		log.info("PRECIO recibido:");
		log.info(precio.toString());
		
		return this.dao.save(precio);
	}

	@Override
	public void borrar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrecioTamanio modificar(long id, PrecioTamanio precio) {
		Optional<PrecioTamanio> op_pt = this.dao.findById(id);
		
		if (op_pt.isPresent()) {
			PrecioTamanio pt = op_pt.get();
			
			pt.setPrecio(precio.getPrecio());
			// Validar si el Tamanio existe en la tabla
			pt.setTamanio(precio.getTamanio());
			// Validar si el Tipo existe en la tabla			
			pt.setTipoprecio(precio.getTipoprecio());
			
			return this.dao.save(pt);
			
		}
		else {
			return null;
		}

	}

}
