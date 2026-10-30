package io.github.unlp_oo.greenHOOme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenServicio extends Orden {
	private String descripcion;
	private int horas;
	private List<Tecnico>tecnicos;
	
	public OrdenServicio(LocalDate fecha, String domicilio, String descripcion, int horas) {
		super(fecha, domicilio);
		this.descripcion = descripcion;
		this.horas = horas;
		tecnicos = new ArrayList<>();
	}
	
	public void agregarTecnico(Tecnico tecnico) {
		tecnicos.add(tecnico);
	}
	
	@Override
	public double calcular() {
	    return tecnicos.stream()
					.mapToDouble(t -> t.getValorHora())
					.sum() * this.horas;
	}
	
	@Override
	public boolean aplicaDescuento() {
		return horas > 10;	
	}

}
