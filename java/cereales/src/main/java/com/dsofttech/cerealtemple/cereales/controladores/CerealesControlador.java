package com.dsofttech.cerealtemple.cereales.controladores;

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

import com.dsofttech.cerealtemple.cereales.IPreciosFeignClient;
import com.dsofttech.cerealtemple.cereales.entidades.Cereal;
import com.dsofttech.cerealtemple.cereales.servicios.ICerealesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/cereales")
public class CerealesControlador {
	
	@Autowired
	private ICerealesService servicio;
	
	@Autowired
	private IPreciosFeignClient preciosClient;
	
	@GetMapping("/all")
	public ResponseEntity<?> obtenerTodos() {
		
		return new ResponseEntity<>(this.servicio.obtenerTodos(), HttpStatus.OK);
		
	}
	

	@GetMapping("/byId")
	public ResponseEntity<?> obtenerPorIdQ(@RequestParam("id") Long id) {
		
		//return new ResponseEntity<>(this.servicio.obtenerPorId(id), HttpStatus.OK);	
		return this._obtenerById(id);
		
	}
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<?> obtenerPorIdP(@PathVariable("id") Long id) {
		
		//return new ResponseEntity<>(this.servicio.obtenerPorId(id), HttpStatus.OK);	
		return this._obtenerById(id);
		
	}
	
	private ResponseEntity<?> _obtenerById(Long id) {
		
		
		ResponseEntity<?> responseEntity = null;
		Optional<Cereal> precio = null;

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
	public ResponseEntity<?> nuevoCereal(@RequestBody Cereal cereal, BindingResult br) {
		
		log.info(cereal.toString());
		
		if (!this.validatePrecio(cereal.getPrecio())) {
			log.info("Tipo de Precio no valido");
			return ResponseEntity.status(500).build();			
		}
		
		ResponseEntity<?> responseEntity = null;
		Cereal c = null;

		if (br.hasErrors()) {
			return ResponseEntity.status(500).build();
		} else {

			c = servicio.nuevo(cereal);
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(c);
		}

		return responseEntity;	
	}

	private boolean validatePrecio(long precio) {
		
		Object response = this.preciosClient.obtenerPorIdP(precio);
		
		if (response != null) {
			return true;
		}
		else {
			return false;			
		}
	}

}
