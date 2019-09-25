package com.jacc.everis.prueba.couldcomprarest.modelo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config")
public class Reorden {
	
	private int reorden;

	public int getReorden() {
		return reorden;
	}

	public void setReorden(int reorden) {
		this.reorden = reorden;
	}
	
	
	
}
