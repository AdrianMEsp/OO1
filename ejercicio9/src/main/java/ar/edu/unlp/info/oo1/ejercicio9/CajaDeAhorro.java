package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta{

	public CajaDeAhorro() {
		super();
	}
	public boolean puedeExtraer(double monto) {
		if (this.getSaldo() - monto  >= 0){
			return true;
		}
		return false;
	}
	@Override
	public void depositar(double monto) {
		super.depositar(monto - monto * 0.02);//2% del costo
	}
	@Override
	public boolean extraer(double monto) {
		return super.extraer(monto * 1.02);
	}
	@Override
	public boolean transferirACuenta(double monto,Cuenta cuentaDestino) {
		return super.transferirACuenta(monto * 1.02, cuentaDestino);
	}
}
