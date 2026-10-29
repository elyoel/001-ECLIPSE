package io.github.unlp_oo.alquilerDePropiedadesConCancelacion;

import java.time.LocalDate;

public class PoliticaEstricta implements Politica {

	@Override
	public double calcularReembolso(Reserva reserva, LocalDate fechaActual) {
		return 0;
	}

}
