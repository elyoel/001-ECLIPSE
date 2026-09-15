package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Circulo implements CaraBasal{
	private double diametro;
	private double radio;
	
	
	public Circulo() {
	}
	
	@Override
	public double getArea() {
		return Math.PI * (radio * radio);
	}
	
	@Override
	public double getPerimetro() {
		return Math.PI * diametro;
	}
	
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
		diametro = radio * 2;
	}
	public double getDiametro() {
		return diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
		radio = diametro / 2;
	}
	
	
}
