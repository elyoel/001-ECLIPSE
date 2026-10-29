package io.github.unlp_oo.alquilerDePropiedadesConCancelacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements Politica {

	@Override
	public double calcularReembolso(Reserva reserva, LocalDate fechaActual) {
		double montoReembolso = reserva.calcularPrecio();
		int tiempoRestante = calcularTiempoRestante(fechaActual, reserva.inicioReservacion());

        if (tiempoRestante >= 7) {
            return montoReembolso;
        } else if (tiempoRestante >= 2) {
            return montoReembolso * 0.5;
        } else {
            return 0;              
        }
	}
	
	public int calcularTiempoRestante(LocalDate dateFrom, LocalDate dateTo) {
		return (int) ChronoUnit.DAYS.between(dateFrom, dateTo);
	}

}
