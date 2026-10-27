package io.github.unlp_oo.intervaloDeTiempo;

import java.time.LocalDate;

public interface IDateLapse {

	// "Retorna la fecha de inicio del rango”
	public LocalDate getFrom();

	// “Retorna la fecha de fin del rango”
	public LocalDate getTo();

	// “Retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
	public int sizeInDays();

	// “recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.
	public boolean includesDate(LocalDate other);

}