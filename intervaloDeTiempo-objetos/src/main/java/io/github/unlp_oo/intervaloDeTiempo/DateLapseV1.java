package io.github.unlp_oo.intervaloDeTiempo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateLapseV1 implements IDateLapse{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapseV1(String from, String to) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.from = LocalDate.parse(from, formato);
		this.to = LocalDate.parse(to, formato);
	}
	
	@Override
	public LocalDate getTo() {
		return to;
	}

	@Override
	public LocalDate getFrom() {
		return from;
	}
	
	@Override
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(from, to);
	}

	@Override
	public boolean includesDate(LocalDate other) {
		return (other.isAfter(from) && other.isBefore(to))
			|| from.equals(other) 
			|| to.equals(other);
	}
}
