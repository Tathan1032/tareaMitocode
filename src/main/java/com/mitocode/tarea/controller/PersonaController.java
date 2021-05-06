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
import com.mitocode.tarea.model.Persona;
import com.mitocode.tarea.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController 
{
	
	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<Persona>> listarPersonas() throws Exception
	{
		
		List<Persona> listaPersonas = service.listar();
		
		return new ResponseEntity<List<Persona>>(listaPersonas, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPersonaPorId( @PathVariable("id") Integer idPersona ) throws Exception
	{
		
		Persona persona = service.listarPorId(idPersona);
		
		if( persona == null)
		{
			throw new ModeloNotFoundException("La persona no existe. ID " + idPersona);
		}
		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Persona> registrarPersona(@Valid @RequestBody Persona persona) throws Exception
	{
		
		Persona nuevaPersona = service.registrar(persona);
		
		return new ResponseEntity<Persona>(nuevaPersona, HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<Persona> modificarPersona(@Valid @RequestBody Persona persona) throws Exception
	{
		
		Persona nuevaPersona = service.modificar(persona);
		
		return new ResponseEntity<Persona>(nuevaPersona, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPersonaPorId( @PathVariable("id") Integer idPersona ) throws Exception
	{
		
		Persona persona = service.listarPorId(idPersona);
		
		if( persona == null)
		{
			throw new ModeloNotFoundException("La persona no existe. ID " + idPersona);
		}
		
		service.eliminar(idPersona);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}

}
