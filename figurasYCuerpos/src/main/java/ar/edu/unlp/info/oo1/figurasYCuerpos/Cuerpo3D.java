package ar.edu.unlp.info.oo1.figurasYCuerpos;

public class Cuerpo3D {
	private double altura;
	private CaraBasal cara;
	
	public Cuerpo3D() {	
	}
	
	public void setCaraBasal(CaraBasal cara) {
		this.cara = cara;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getVolumen() {
		return cara.getArea() * altura;
	}
	
	public double getSuperficieExterior() {
		return 2 * cara.getArea() + cara.getPerimetro() * altura;
	}
}
