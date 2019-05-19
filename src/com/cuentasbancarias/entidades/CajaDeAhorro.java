package com.cuentasbancarias.entidades;

public class CajaDeAhorro extends CuentaBancaria {
	private Integer cantidadDeExtracciones;

	public CajaDeAhorro() {
		super();
		this.cantidadDeExtracciones = 0;
	}

	@Override
	public void extraer(Double dinero) {
		if (this.cantidadDeExtracciones > 5) {
			super.extraer(dinero + 6.0d);
		} else {
			super.extraer(dinero);
		}

		this.incrementarCantidadDeExtracciones();
	}

	private void incrementarCantidadDeExtracciones() {
		this.cantidadDeExtracciones += 1;
	}
}
