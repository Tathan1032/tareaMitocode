package com.mitocode.tarea.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.tarea.model.Persona;
import com.mitocode.tarea.repository.IGenericRepo;
import com.mitocode.tarea.repository.IPersonaRepo;
import com.mitocode.tarea.service.IPersonaService;

@Service
public class PersonaServiceImplementation extends CRUDImplementation<Persona, Integer> implements IPersonaService 
{
	
	@Autowired
	private IPersonaRepo repository;
	
	@Override
	protected IGenericRepo<Persona, Integer> getRepo() 
	{
		return repository;
	}

}
