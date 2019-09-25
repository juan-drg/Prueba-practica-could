package com.jacc.everis.prueba.couldinventariorest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacc.everis.prueba.couldinventariorest.modelo.ProductoModel;
import com.jacc.everis.prueba.couldinventariorest.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public ProductoModel buscar(int id) {
		return productoRepository.findById(id).get();
	}
}
