package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Cuadrado implements CaraBasal {
	private double lado;
	
	public Cuadrado() {
	}

	@Override
	public double getArea() {
		return lado * lado;
	}

	@Override
	public double getPerimetro() {
		return lado * 4;
	}
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}


	
	
}
