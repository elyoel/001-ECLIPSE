package io.github.unlp_oo.greenHOOme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenServicio extends Orden {
	private String descripcion;
	private int horas;
	private List<Tecnico>tecnicos;
	
	public OrdenServicio(LocalDate fecha, String domicilio, String descripcion, int horas, List<Tecnico> tecnicos) {
		super(fecha, domicilio);
		this.descripcion = descripcion;
		this.horas = horas;
		this.tecnicos = tecnicos;
	}
	public double calcular() {
		// TODO Auto-generated method stub
	    return tecnicos.stream()
					.mapToDouble(t -> t.getValorHora()* this.horas)
					.sum();
	}

}
