package io.github.unlp_oo.alquilerDePropiedadesConCancelacion;

import java.time.LocalDate;

public interface Politica {
	
	public double calcularReembolso(Reserva reserva, LocalDate fechaActual);
}
