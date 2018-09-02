package com.spring.mvc.entity;

import org.springframework.beans.factory.annotation.Value;

public class Saludo {

	@Value(value= "hola")
	private String saludo;

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
	
}
