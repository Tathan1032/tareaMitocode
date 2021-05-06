package com.mitocode.tarea.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.tarea.model.Venta;
import com.mitocode.tarea.service.IVentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController 
{
	
	@Autowired
	private IVentaService service;
		
	@PostMapping
	public ResponseEntity<Venta> registrarVenta(@Valid @RequestBody Venta venta) throws Exception
	{
		
		Venta nuevaVenta = service.registrarTransaccional(venta);
		
		return new ResponseEntity<Venta>(nuevaVenta, HttpStatus.CREATED);
		
	}
	
}
