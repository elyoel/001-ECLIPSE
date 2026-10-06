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
	
	private boolean tengoPadre() {
		return padre != null;
	}
	private boolean tengoMadre() {
		return madre != null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (tengoMadre())
			return madre.getPadre();
		return null;
	}
	public Mamifero getAbuelaMaterna() {
		if (tengoMadre())
			return madre.getMadre();
		return null;
	}
	public Mamifero getAbueloPaterno() {
		if (tengoPadre())
			return padre.getPadre();
		return null;
	}
	public Mamifero getAbuelaPaterna() {
		if (tengoPadre())
			return padre.getMadre();
		return null;
	}
	
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		Queue<Mamifero> cola = new LinkedList<>();
		if (tengoPadre())
			cola.offer(padre);
		if (tengoMadre())
			cola.offer(madre);
		boolean esAncestro = false;
		Mamifero aux = null;
		while (!cola.isEmpty() && !esAncestro) {
			aux = cola.poll();
			if (aux == unMamifero){
				esAncestro = true;
			} else {
				if (aux.tengoPadre())
					cola.offer(aux.getPadre());
				if (aux.tengoMadre())
					cola.offer(aux.getMadre());
			}
		}
		return esAncestro;
	}
}
