package io.github.unlp_oo.VolumenYSuperficie;

public class PrismaRectangular extends Pieza {
	private double altura;
	private double ladoMayor;
	private double ladoMenor;
	
	public PrismaRectangular(String color, String material, double altura, double ladoMayor, double ladoMenor) {
		super(color, material);
		this.altura = altura;
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
	}

	@Override
	public double getSuperficie() {
		return 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura);
	}

	@Override
	public double getVolumen() {
		return ladoMenor * ladoMayor * altura;
	}

}
