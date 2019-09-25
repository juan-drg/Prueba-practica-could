package com.jacc.everis.prueba.couldcomprarest.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jacc.everis.prueba.couldcomprarest.modelo.Reorden;
import com.jacc.everis.prueba.couldcomprarest.responses.CompraResponse;

@RestController
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	Reorden reorden;
	
	@GetMapping("/")
	public String saludo() {
		return "Hola desde compras, este es tu reorden: " + reorden.getReorden();
	}

	@GetMapping("/id/{id}/cantidad/{cantidad}/")
	public CompraResponse compra(@PathVariable int id, @PathVariable int cantidad) {
		CompraResponse response = new CompraResponse();
//		String url = "http://localhost:8000/productos/id/{id}";
		String url = "http://192.168.0.11:8000/productos/id/{id}";
		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("id", id);
		try {
			ResponseEntity<CompraResponse> respuesta = new RestTemplate().getForEntity(url, CompraResponse.class, uriVariables);
			response = respuesta.getBody();
			Integer stock = response.getProductoModel().getStock();
			Integer maximocompra = stock - (stock*reorden.getReorden()/100);
			if(cantidad <= maximocompra) {
				if(stock >= cantidad) {
					response.setExito(true);
					response.setMensaje("Existe disponibilidad de productos");
				}
			}else {
				response.setExito(false);
				response.setMensaje("Actualmente no hay disponibilidad de productos");
			}
		}catch(Exception e) {
				response.setExito(false);
				response.setMensaje("Actualmente no hay disponibilidad de productos. " + e.getMessage());
		}
		return response;
	}
	
}
