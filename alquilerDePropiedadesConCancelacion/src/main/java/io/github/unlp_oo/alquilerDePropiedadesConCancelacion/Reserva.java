package io.github.unlp_oo.alquilerDePropiedadesConCancelacion;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodo;
	private Usuario inquilino;
	private Propiedad alquiler;
	
	public Reserva(DateLapse periodo, Usuario inquilino, Propiedad alquiler) {
		this.periodo = periodo;
		this.inquilino = inquilino;
		this.alquiler = alquiler;
	}
	
	public boolean consultarDisponibilidad(DateLapse perido) {
		return !this.periodo.overlaps(periodo);
	}

	public double calcularPrecio() {
		return calcularDias() * alquiler.getPrecioNoche();
	}
	
	public int calcularDias() {
		return periodo.sizeInDays();
	}
	
	public boolean estaEnCurso() {
		return periodo.includesDate(LocalDate.now());
	}

	public LocalDate inicioReservacion() {
		return periodo.getFrom();
	}
}
