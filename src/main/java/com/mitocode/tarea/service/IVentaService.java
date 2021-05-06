package com.mitocode.tarea.service;

import com.mitocode.tarea.model.Venta;

public interface IVentaService extends ICRUD<Venta, Integer>
{
	
	Venta registrarTransaccional(Venta venta) throws Exception;

}
