package io.github.unlp_oo.clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		emails = new ArrayList<>();
	}
	
	public void mover(Email email, Carpeta carpeta) {
		emails.remove(email);
		carpeta.agregarMail(email);
	}
	
	public void agregarMail(Email email) {
		emails.add(email);
	}
	
	public Email buscar(String texto) {
		return emails.stream()
			.filter(e -> e.contieneTexto(texto))
			.findFirst()
			.orElse(null);
	}
	
	public int tamaño() {
		return emails.stream()
			.mapToInt(e -> e.tamaño())
			.sum();
	}
}
