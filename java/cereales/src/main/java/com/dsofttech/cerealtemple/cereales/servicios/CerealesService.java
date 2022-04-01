package com.dsofttech.cerealtemple.cereales.servicios;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsofttech.cerealtemple.cereales.dao.ICerealesDao;
import com.dsofttech.cerealtemple.cereales.entidades.Cereal;

@Service
public class CerealesService implements ICerealesService {

	private Logger log = LoggerFactory.getLogger(CerealesService.class);

	@Autowired
	private ICerealesDao dao;

	@Override
	public List<Cereal> obtenerTodos() {
		return this.dao.findAll();
	}

	@Override
	public Cereal obtenerPorId(long id) {
		return this.dao.getById(id);
	}

	@Override
	public List<Cereal> obtenerPorTipo(long tipo) {

		Cereal c = new Cereal();
		c.setIdcereal(tipo);

		return this.dao.findByprecio(c);

	}

	@Override
	public Cereal nuevo(Cereal cereal) {
		
		log.info("PRECIO recibido:");
		log.info(cereal.toString());
		
		return this.dao.save(cereal);
	}

	@Override
	public void borrar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cereal modificar(long id, Cereal cereal) {
		// TODO Auto-generated method stub
		return null;
	}

}
