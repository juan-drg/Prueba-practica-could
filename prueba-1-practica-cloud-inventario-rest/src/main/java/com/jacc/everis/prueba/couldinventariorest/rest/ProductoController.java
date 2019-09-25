package com.jacc.everis.prueba.couldinventariorest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacc.everis.prueba.couldinventariorest.modelo.ProductoModel;
import com.jacc.everis.prueba.couldinventariorest.responses.ProductoResponses;
import com.jacc.everis.prueba.couldinventariorest.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/id/{id}")
	public ProductoResponses buscar(@PathVariable int id) {
		ProductoResponses response = new ProductoResponses();
		try {
			ProductoModel productoEncontrado= productoService.buscar(id);
			if(productoEncontrado == null) {
				response.setExito(false);
				response.setMensaje("Producto No encontrado");
				return response;
			}
			productoEncontrado.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			response.setExito(true);
			response.setMensaje("Producto en existencia");
			response.setProductoModel(productoEncontrado);
		}catch(Exception e) {
			response.setExito(false);
			response.setMensaje("Producto No encontrado. " + e.getLocalizedMessage());
		}
		return response;
	}
}
