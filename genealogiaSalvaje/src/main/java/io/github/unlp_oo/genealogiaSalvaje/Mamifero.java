package io.github.unlp_oo.genealogiaSalvaje;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre, madre;
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
		padre = null;
		madre = null;
	}
	

	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	
	public Mamifero getAbueloMaterno() {
		if (madre != null)
			return madre.getPadre();
		return null;
	}
	public Mamifero getAbuelaMaterna() {
		if (madre != null)
			return madre.getMadre();
		return null;
	}
	public Mamifero getAbueloPaterno() {
		if (padre != null)
			return padre.getPadre();
		return null;
	}
	public Mamifero getAbuelaPaterna() {
		if (padre != null)
			return padre.getMadre();
		return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		Queue<Mamifero> cola = new LinkedList<>();
		if (padre != null)
			cola.offer(padre);
		if (madre != null)
			cola.offer(madre);
		boolean esAncestro = false;
		Mamifero aux = null;
		while (!cola.isEmpty() && !esAncestro) {
			aux = cola.poll();
			if (aux == unMamifero){
				esAncestro = true;
			} else {
				if (aux.getPadre() != null)
					cola.offer(aux.getPadre());
				if (aux.getMadre() != null)
					cola.offer(aux.getMadre());
			}
		}
		return esAncestro;
	}
}
