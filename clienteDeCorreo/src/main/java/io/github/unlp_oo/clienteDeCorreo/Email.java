package io.github.unlp_oo.clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Email {
	
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo, List<Archivo> adjuntos) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = adjuntos;
	}
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<>();
	}
	
	public boolean contieneTexto(String texto) {
		return titulo.contains(texto) || cuerpo.contains(texto);
	}
	
	public int tamaño() {
		return getTitulo().length() + getCuerpo().length() +
			adjuntos.stream()
			.mapToInt(a -> a.tamaño())
			.sum();
	}
	
	public List<Archivo> adjuntos(){
		return new ArrayList<>(adjuntos);
	}
	
	public String getCuerpo() {
		return cuerpo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	
	
}
