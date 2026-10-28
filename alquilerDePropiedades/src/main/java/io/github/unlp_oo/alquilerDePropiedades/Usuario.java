package io.github.unlp_oo.alquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propiedades;
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		propiedades = new ArrayList<>();
	}
	
	public double calcularIngresos(DateLapse periodo) {
		return propiedades.stream()
			.filter(p -> !p.consultarDisponibilidad(periodo))
			.mapToDouble(p -> p.calcularMontoTotal())
			.sum() * 0.75;
	}
	
}
