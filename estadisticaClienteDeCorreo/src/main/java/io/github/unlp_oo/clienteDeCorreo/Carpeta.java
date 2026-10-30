package io.github.unlp_oo.clienteDeCorreo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import io.github.unlp_oo.bag.*;

public class Carpeta {
	
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		emails = new ArrayList<>();
	}
	
	public void mover(Email email, Carpeta carpeta) {
		if (emails.contains(email)) {
			emails.remove(email);
			carpeta.agregarMail(email);
		}
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
	
	public List<Email> getEmails(){
		return new ArrayList<>(emails);
	}
	
	public int cantidadMails() {
		return emails.size();
	}
	
	public Bag<String> cantidadMailsPorCategoria(){
		Bag<String> contador = new BagImpl<>();
		emails.forEach(e -> contador.add(e.getCategoria()));
		return contador;
	}
	
	public String reporteMailPorDia() {
		String aux = "";
		Bag<String> contador = new BagImpl<>();
		emails.forEach(e -> contador.add(e.getFecha()));
		Iterator<String> it = contador.iterator();
		Set<String> fechas = new HashSet<>();
		while (it.hasNext()) {
		    String f = it.next();
		    if (!fechas.contains(f)) {
		    	aux += f + " - " + contador.occurrencesOf(f) + " emails" + "\n";
		    	fechas.add(f);
		    }
		}
		return aux;
	}
}
