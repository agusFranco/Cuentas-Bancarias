package com.cuentasbancarias.entidades;

public abstract class CuentaBancaria {
	protected Double saldo;

	public CuentaBancaria() {
		this.saldo = 0.0d;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void depositar(Double dinero) {
		this.saldo += dinero;
	}

	public void extraer(Double dinero) {
		if (this.saldo < dinero) {
			throw new RuntimeException("Saldo Insuficiente");
		}

		this.saldo -= dinero;
	}
}
