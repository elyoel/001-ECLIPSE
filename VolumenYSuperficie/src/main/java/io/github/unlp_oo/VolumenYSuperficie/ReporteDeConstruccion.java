package io.github.unlp_oo.VolumenYSuperficie;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		piezas = new ArrayList<>();
	}
	
	public double volumenDeMaterial(String material) {
		double volumenTotal = 0;
		for (Pieza pieza: piezas) {
			if (pieza.getMaterial().equals(material))
				volumenTotal += pieza.getVolumen();
		}
		return volumenTotal;
	}
	
	public double superficieDeColor(String color) {
		double superfieTotal = 0;
		for (Pieza pieza: piezas) {
			if (pieza.getColor().equals(color))
				superfieTotal += pieza.getSuperficie();
		}
		return superfieTotal;
	}
}
