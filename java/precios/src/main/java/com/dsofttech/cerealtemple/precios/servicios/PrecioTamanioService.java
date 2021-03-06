package com.dsofttech.cerealtemple.precios.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsofttech.cerealtemple.precios.dao.IPrecioTamanioDao;
import com.dsofttech.cerealtemple.precios.entidades.Precio;
import com.dsofttech.cerealtemple.precios.entidades.PrecioTamanio;

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
		// TODO Auto-generated method stub
		return null;
	}

}
