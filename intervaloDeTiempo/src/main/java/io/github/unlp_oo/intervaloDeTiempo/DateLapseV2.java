package io.github.unlp_oo.intervaloDeTiempo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateLapseV2 implements IDateLapse {
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapseV2(String from, int sizeInDays) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.from = LocalDate.parse(from, formato);
		this.sizeInDays = sizeInDays;
	}
	
	@Override
	public LocalDate getFrom() {
		return from;
	}

	@Override
	public LocalDate getTo() {
		return from.plusDays(sizeInDays);
	}

	@Override
	public int sizeInDays() {
		return sizeInDays;
	}

	@Override
	public boolean includesDate(LocalDate other) {
		return (other.isAfter(from) && other.isBefore(getTo()))
				|| from.equals(other) 
				|| getTo().equals(other);
	}

}
