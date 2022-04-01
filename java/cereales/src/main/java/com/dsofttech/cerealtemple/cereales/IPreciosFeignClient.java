package com.dsofttech.cerealtemple.cereales;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="gestion-precios")
public interface IPreciosFeignClient {
	
	@GetMapping("/tipoprecios/byId")
	public ResponseEntity<?> obtenerPorIdQ(@RequestParam("id") Long id);
	
	@GetMapping("/tipoprecios/byId/{id}")
	public ResponseEntity<?> obtenerPorIdP(@PathVariable("id") Long id);

}
