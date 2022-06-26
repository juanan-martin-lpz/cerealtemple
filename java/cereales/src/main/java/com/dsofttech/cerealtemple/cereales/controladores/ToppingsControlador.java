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

import com.dsofttech.cerealtemple.cereales.entidades.Toppings;
import com.dsofttech.cerealtemple.cereales.servicios.IToppingsService;

@RestController
@RequestMapping("/toppings")
public class ToppingsControlador {
	
	@Autowired
	private IToppingsService servicio;
	
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
		Optional<Toppings> topping = null;

		topping = Optional.ofNullable(servicio.obtenerPorId(id));
		
		
		if (topping.isPresent()) {
			responseEntity = ResponseEntity.ok(topping.get());
		} else {
			// no hay
			responseEntity = ResponseEntity.notFound().build();
		}
		
		return responseEntity;	
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> nuevoCereal(@RequestBody Toppings topping , BindingResult br) {
		
		ResponseEntity<?> responseEntity = null;
		Toppings t = null;

		if (br.hasErrors()) {
			return ResponseEntity.status(500).build();
		} else {

			t = servicio.nuevo(topping);
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(t);
		}

		return responseEntity;	
	}
}
