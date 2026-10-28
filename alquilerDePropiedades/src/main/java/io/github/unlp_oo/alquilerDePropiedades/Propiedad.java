package io.github.unlp_oo.alquilerDePropiedades;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String direccion;
	private double precioNoche;
	private List<Reserva> reservas;
	
	public Propiedad(String nombre, String direccion, double precioNoche) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioNoche = precioNoche;
		reservas = new ArrayList<>();
	}
	
	public boolean consultarDisponibilidad(DateLapse periodo) {
		return reservas.stream()
			.allMatch(r -> r.consultarDisponibilidad(periodo));
	}
	
	public void crearReserva(Usuario inquilino, DateLapse periodo) {
		if (consultarDisponibilidad(periodo)) {
			reservas.add(new Reserva(periodo, inquilino, this));
		}
	}
	
	public double calcularMontoTotal() {
		return reservas.stream()
			.mapToDouble(r -> r.calcularPrecio())
			.sum();
	}
	
	public void cancelarReserva(Reserva reserva) {
		if (!reserva.estaEnCurso()) {
			reservas.remove(reserva);
		}
	}

	public double getPrecioNoche() {
		return precioNoche;
	}
}
