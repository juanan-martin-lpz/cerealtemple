package com.dsofttech.cerealtemple.mantenimientos.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsofttech.cerealtemple.mantenimientos.entidades.Color;
import com.dsofttech.cerealtemple.mantenimientos.servicios.IColoresService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/colores")
public class ColoresController {

	@Autowired
	private IColoresService servicio;
	
	@GetMapping("/all")
	public ResponseEntity<?> obtenerTodos() {
		
		return new ResponseEntity<>(this.servicio.obtenerTodos(), HttpStatus.OK);
		
	}
	

	@GetMapping("/byId")
	public ResponseEntity<?> obtenerPorIdQ(@RequestParam("id") int id) {
		
		//return new ResponseEntity<>(this.servicio.obtenerPorId(id), HttpStatus.OK);	
		return this._obtenerById(id);
		
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<?> obtenerPorIdP(@PathVariable("id") int id) {
		
		//return new ResponseEntity<>(this.servicio.obtenerPorId(id), HttpStatus.OK);	
		return this._obtenerById(id);
		
	}
	
	private ResponseEntity<?> _obtenerById(int id) {
		
		
		ResponseEntity<?> responseEntity = null;
		Optional<Color> color = null;

		color = Optional.ofNullable(servicio.obtenerPorId(id));
		
		
		if (color.isPresent()) {
			responseEntity = ResponseEntity.ok(color.get());
		} else {
			// no hay
			responseEntity = ResponseEntity.notFound().build();
		}
		
		return responseEntity;	
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> nuevoColor(@RequestBody Color color, BindingResult br) {
		
		log.info(color.toString());
		
		ResponseEntity<?> responseEntity = null;
		Color c = null;

		if (br.hasErrors()) {
			return ResponseEntity.status(500).build();
		} else {

			c = servicio.nuevo(color);
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(c);
		}

		return responseEntity;	
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> actualizaColor(@PathVariable("id") int id, @RequestBody Color color, BindingResult br) {
		
		ResponseEntity<?> responseEntity = null;

		Color c = null;

		if (br.hasErrors()) {
			return ResponseEntity.status(500).build();
		} else {

			c = servicio.modificar(id, color);
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(c);
		}

		return responseEntity;	
	}

}
