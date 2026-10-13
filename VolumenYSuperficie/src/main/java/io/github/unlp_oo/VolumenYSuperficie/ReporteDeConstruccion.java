package io.github.unlp_oo.VolumenYSuperficie;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		piezas = new ArrayList<>();
	}
	
	public double volumenDeMaterial(String material) {
		return piezas.stream()
			.filter(p -> p.equals(material))
			.mapToDouble(p -> p.getSuperficie())
			.sum();
	}
	
	public double superficieDeColor(String color) {
		return piezas.stream()
			.filter(p -> p.getColor().equals(color))
			.mapToDouble(p -> p.getSuperficie())
			.sum();
	}
}
