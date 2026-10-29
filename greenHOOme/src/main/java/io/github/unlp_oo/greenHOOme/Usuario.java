package io.github.unlp_oo.greenHOOme;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombreCompleto;
	private String direccion;
	private List<Orden> ordenes;
	
	public Usuario(String nombreCompleto, String direccion) {
		this.nombreCompleto = nombreCompleto;
		this.direccion = direccion;
		ordenes = new ArrayList<>();
		}
	
	public void agregarOrden(Orden orden) {
		
	}
	
	
}
