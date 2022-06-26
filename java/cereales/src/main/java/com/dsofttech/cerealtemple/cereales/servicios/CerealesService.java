package com.dsofttech.cerealtemple.cereales.servicios;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dsofttech.cerealtemple.cereales.dao.ICerealesDao;
import com.dsofttech.cerealtemple.cereales.entidades.Cereal;

@Service
public class CerealesService implements ICerealesService {


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
	public Cereal nuevo(Cereal cereal, MultipartFile archivo) {
		
		try {
			cereal.setImagen(archivo.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.dao.save(cereal);
	}

	@Override
	public void borrar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cereal modificar(long id, Cereal cereal, MultipartFile archivo) {
		
		Optional<Cereal> c = this.dao.findById(id);
		
		if (c.isPresent()) {
		
			Cereal cl = c.get();
			
			try {
				
				cl.setNombre(cereal.getNombre());
				cl.setPrecio(cereal.getPrecio());
				cl.setDescripcion(cereal.getDescripcion());
				
				if (archivo != null) {
					cl.setImagen(archivo.getBytes());					
				}
								
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return this.dao.save(cl);
			
		}
		else {
			return null;
		}
	}

}
