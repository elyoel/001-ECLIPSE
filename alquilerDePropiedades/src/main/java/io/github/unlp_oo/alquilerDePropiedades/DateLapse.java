package io.github.unlp_oo.alquilerDePropiedades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateLapse{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(String from, String to) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.from = LocalDate.parse(from, formato);
		this.to = LocalDate.parse(to, formato);
	}
	
	public LocalDate getTo() {
		return to;
	}

	public LocalDate getFrom() {
		return from;
	}
	
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(from, to);
	}

	public boolean includesDate(LocalDate other) {
		return (other.isAfter(from) && other.isBefore(to))
			|| from.equals(other) 
			|| to.equals(other);
	}
	
	public boolean overlaps(DateLapse anotherDateLapse) {
		return includesDate(anotherDateLapse.getFrom()) || includesDate(anotherDateLapse.getTo());
	}
}
