package com.mitocode.tarea.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.tarea.model.Venta;
import com.mitocode.tarea.repository.IGenericRepo;
import com.mitocode.tarea.repository.IVentaRepo;
import com.mitocode.tarea.service.IVentaService;

@Service
public class VentaServiceImplementation extends CRUDImplementation<Venta, Integer> implements IVentaService 
{
	
	@Autowired
	private IVentaRepo repository;
	
	@Override
	protected IGenericRepo<Venta, Integer> getRepo() 
	{
		return repository;
	}
	
	@Override
	public Venta registrarTransaccional(Venta venta) throws Exception 
	{
		
		venta.getDetalleVenta().forEach( detalle -> detalle.setVenta(venta) );
		
		return repository.save(venta);
	}
	
}
