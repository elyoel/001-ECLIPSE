package io.github.unlp_oo.greenHOOme;

public class Tecnico {
	private String nombreCompleto;
	private String especialidad;
	private double valorHora;
	public Tecnico(String nombreCompleto, String especialidad, double valorHora) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.especialidad = especialidad;
		this.valorHora = valorHora;
	}
	
	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public String toString() {
		return "Tecnico [nombreCompleto=" + nombreCompleto + ", especialidad=" + especialidad + ", valorHora="
				+ valorHora + "]";
	}
	
}
