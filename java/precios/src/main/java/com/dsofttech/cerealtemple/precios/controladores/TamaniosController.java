package com.dsofttech.cerealtemple.precios.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsofttech.cerealtemple.precios.entidades.Tamanio;
import com.dsofttech.cerealtemple.precios.servicios.ITamanioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/tamanios")
public class TamaniosController {

	@Autowired
	private ITamanioService servicio;
	
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
		Optional<Tamanio> precio = null;

		precio = Optional.ofNullable(servicio.obtenerPorId(id));
		
		
		if (precio.isPresent()) {
			responseEntity = ResponseEntity.ok(precio.get());
		} else {
			// no hay
			responseEntity = ResponseEntity.notFound().build();
		}
		
		return responseEntity;	
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> nuevPrecioTamanio(@RequestBody Tamanio tamanio, BindingResult br) {
		
		log.info(tamanio.toString());
		
		ResponseEntity<?> responseEntity = null;
		Tamanio p = null;

		if (br.hasErrors()) {
			return ResponseEntity.status(500).build();
		} else {

			p = servicio.nuevo(tamanio);
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(p);
		}

		return responseEntity;	
	}


}
