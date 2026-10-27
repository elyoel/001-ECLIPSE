package io.github.unlp_oo.clienteDeCorreo;

public class Archivo {
	private String nombre;
	
	public Archivo(String nombre) {
		this.nombre = nombre;
	}
	
	public int tamaño() {
		return nombre.length();
	}
}
