package io.github.unlp_oo.cuentaConGanchos;

public class CuentaCorriente extends Cuenta {
	private double descubierto;
	
	public CuentaCorriente() {
		setDescubierto(0);
	}
	
	@Override
	protected boolean puedeExtraer(double monto) {
		return monto <= calcularSaldoConDescubierto();
	}
	
	private double calcularSaldoConDescubierto() {
		return super.getSaldo() + descubierto;
	}
	
	public double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}

}
