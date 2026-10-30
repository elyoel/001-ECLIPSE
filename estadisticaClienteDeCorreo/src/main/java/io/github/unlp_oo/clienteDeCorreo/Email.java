package io.github.unlp_oo.clienteDeCorreo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Email {
	
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	private LocalDate fecha;
	
	public Email(String titulo, String cuerpo, LocalDate fecha, List<Archivo> adjuntos) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = adjuntos;
		this.fecha = fecha;
	}
	public Email(String titulo, String cuerpo, LocalDate fecha) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<>();
		this.fecha = fecha;
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
	
	public String getCategoria() {
		int tamaño = tamaño();
		if (tamaño > 500)
			return "Grande";
		else if (tamaño > 300)
			return "Mediano";
		return "Pequeño";
	}
	
	public String getFecha() {
		LocalDate date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = date.format(formatter);
		return formattedDate;
	}
	
}
