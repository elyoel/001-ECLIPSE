package io.github.unlp_oo.alquilerDePropiedadesConCancelacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String direccion;
	private double precioNoche;
	private List<Reserva> reservas;
	private Politica politica;
	
	public Propiedad(String nombre, String direccion, double precioNoche, Politica politica) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.precioNoche = precioNoche;
		reservas = new ArrayList<>();
		this.politica = politica;
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
	
	public double cancelarReserva(Reserva reserva, LocalDate fechaActual) {
		if (!reserva.estaEnCurso()) {
			reservas.remove(reserva);
			return politica.calcularReembolso(reserva, fechaActual);
		}
		return 0;
	}

	public double getPrecioNoche() {
		return precioNoche;
	}
}
