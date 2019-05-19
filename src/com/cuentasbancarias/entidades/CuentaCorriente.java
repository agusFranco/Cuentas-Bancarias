package com.cuentasbancarias.entidades;

public class CuentaCorriente extends CuentaBancaria {
		private Double limiteDescubierto;

		public CuentaCorriente(Double limiteDescubierto) {
			super();
			this.limiteDescubierto = limiteDescubierto;
		}

		@Override
		public void extraer(Double dinero) {
			if (this.saldo >= dinero) {
				super.extraer(dinero);
				return;
			}

			this.extraerConDescubierto(dinero);
		}

		private void extraerConDescubierto(Double dinero) {
			Double saldoConDescubierto = this.saldo + this.limiteDescubierto;
			Double descubiertoUsado = 0.0d;
			Double limiteDescubiertoRestante = 0.0d;

			if (saldoConDescubierto < dinero) {
				throw new RuntimeException("Saldo Insuficiente");
			}

			// Extraigo el dinero del total el dinero
			saldoConDescubierto -= dinero;
			// Lo que me queda, es el descubierto restante
			limiteDescubiertoRestante = saldoConDescubierto;
			// Calculo lo que se uso
			descubiertoUsado = this.limiteDescubierto - limiteDescubiertoRestante;
			// Calculo el saldo negativo
			this.saldo = (descubiertoUsado * 0.05d) * -1;
			// Asigno el descubierto restante
			this.limiteDescubierto = limiteDescubiertoRestante;
		}
	}


