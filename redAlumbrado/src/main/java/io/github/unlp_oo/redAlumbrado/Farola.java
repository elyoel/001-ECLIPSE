package io.github.unlp_oo.redAlumbrado;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private boolean estado;
	private List<Farola> vecinos;
	
	/*
	 * Crear una farola. Debe inicializarla como apagada
	 */
	public Farola() {
		estado = false;
		vecinos = new ArrayList<>();
	}

	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	public void pairWithNeighbor( Farola otraFarola ) {
		if (!vecinos.contains(otraFarola)) {
			vecinos.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}	

	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return new ArrayList<>(vecinos);
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (isOff()) {
			estado = true;
			for (Farola vecino: vecinos) {
				if (vecino.isOff()) vecino.turnOn();
			}
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (isOn()) {
			estado = false;
			for (Farola vecino: vecinos) {
				if (vecino.isOn()) vecino.turnOff();
			}
		}
	}

	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return estado == true;
	}

	/*
	* Retorna true si la farola está apagada.
	*/
	public boolean isOff() {
		return estado == false;
	}

}
