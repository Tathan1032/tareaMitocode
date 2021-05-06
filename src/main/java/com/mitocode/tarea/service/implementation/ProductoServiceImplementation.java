package com.mitocode.tarea.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.tarea.model.Producto;
import com.mitocode.tarea.repository.IGenericRepo;
import com.mitocode.tarea.repository.IProductoRepo;
import com.mitocode.tarea.service.IProductoService;

@Service
public class ProductoServiceImplementation extends CRUDImplementation<Producto, Integer> implements IProductoService 
{
	
	@Autowired
	private IProductoRepo repository;
	
	@Override
	protected IGenericRepo<Producto, Integer> getRepo()
	{
		return repository;		
	}

}
