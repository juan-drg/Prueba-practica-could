package com.jacc.everis.prueba.couldcomprarest.responses;

import com.jacc.everis.prueba.couldcomprarest.modelo.ProductoModel;

public class CompraResponse {

	private boolean exito;
	private String mensaje;
	private ProductoModel productoModel;
	public boolean isExito() {
		return exito;
	}
	public void setExito(boolean exito) {
		this.exito = exito;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public ProductoModel getProductoModel() {
		return productoModel;
	}
	public void setProductoModel(ProductoModel productoModel) {
		this.productoModel = productoModel;
	}
	
	
	
}
