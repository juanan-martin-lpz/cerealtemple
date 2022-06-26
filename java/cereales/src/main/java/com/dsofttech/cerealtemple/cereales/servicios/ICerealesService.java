package com.dsofttech.cerealtemple.cereales.servicios;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dsofttech.cerealtemple.cereales.entidades.Cereal;


public interface ICerealesService {
	
	public List<Cereal> obtenerTodos();
	public Cereal obtenerPorId(long id);
	
	public List<Cereal> obtenerPorTipo(long tipo);
	
	public Cereal nuevo(Cereal cereal, MultipartFile archivo);
	public void borrar(long id);
	public Cereal modificar(long id, Cereal cereal, MultipartFile archivo);

}
