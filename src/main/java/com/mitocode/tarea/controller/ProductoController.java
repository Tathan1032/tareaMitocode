package com.mitocode.tarea.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.tarea.exception.ModeloNotFoundException;
import com.mitocode.tarea.model.Producto;
import com.mitocode.tarea.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController 
{
	
	@Autowired
	private IProductoService service;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listarProductos() throws Exception
	{
		
		List<Producto> listaProductos = service.listar();
		
		return new ResponseEntity<List<Producto>>(listaProductos, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarProductoPorId( @PathVariable("id") Integer idProducto ) throws Exception
	{
		
		Producto producto = service.listarPorId(idProducto);
		
		if( producto == null)
		{
			throw new ModeloNotFoundException("El producto no existe. ID " + idProducto);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Producto> registrarProducto(@Valid @RequestBody Producto producto) throws Exception
	{
		
		Producto nuevoProducto = service.registrar(producto);
		
		return new ResponseEntity<Producto>(nuevoProducto, HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Producto> modificarProducto(@Valid @RequestBody Producto producto) throws Exception
	{
		
		Producto nuevoProducto = service.modificar(producto);
		
		return new ResponseEntity<Producto>(nuevoProducto, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProductoPorId( @PathVariable("id") Integer idProducto ) throws Exception
	{
		
		Producto producto = service.listarPorId(idProducto);
		
		if( producto == null)
		{
			throw new ModeloNotFoundException("El producto no existe. ID " + idProducto);
		}
		
		service.eliminar(idProducto);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}

}
