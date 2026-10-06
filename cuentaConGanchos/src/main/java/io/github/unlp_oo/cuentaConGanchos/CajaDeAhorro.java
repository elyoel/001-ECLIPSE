package io.github.unlp_oo.cuentaConGanchos;

public class CajaDeAhorro extends Cuenta{
	private final double interes = 2;
	
	public CajaDeAhorro() {
	}
	
	@Override
	protected boolean puedeExtraer(double monto) {
		return monto + calcularCostoAdicional(monto) <= getSaldo();
	}

	private double calcularCostoAdicional(double monto) {
		double porcentaje = (interes / 100);
		return monto * porcentaje;
	}
	
	protected void extraerSinControlar(double monto) {
		monto += calcularCostoAdicional(monto);
		super.extraerSinControlar(monto);
	}
	
	public void depositar(double monto) {
		monto -= calcularCostoAdicional(monto);
		super.depositar(monto);
	}
}
	
