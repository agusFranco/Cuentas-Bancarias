package com.cuentasbancarias.entidadesTest;

import org.junit.Assert;
import org.junit.Test;
import com.cuentasbancarias.entidades.*;

public class CuentaCorrienteTest {

	@Test
	public void extraerConDescubierto() {

		// Prueba cuando el limite de descubierto es suficiente
		final double limiteDescubierto = 2000;
		final double dineroParaDeposito = 1000;
		final double dineroDeExtraccion = 1500;
		final double saldoNegativo = ((dineroDeExtraccion - dineroParaDeposito) * 0.05d) * -1;
		CuentaBancaria cuentaCorrienteBancoProvincia = new CuentaCorriente(limiteDescubierto);
		cuentaCorrienteBancoProvincia.depositar(dineroParaDeposito);
		cuentaCorrienteBancoProvincia.extraer(dineroDeExtraccion);
		Assert.assertTrue(saldoNegativo == cuentaCorrienteBancoProvincia.getSaldo());
	}

	@Test
	public void extraer() {
		// Extraccion normal sin descubierto
		final double dineroParaDeposito = 1000;
		final double dineroParaExtraccion = 500;
		final double limiteDescubierto = 2000;
		final double saldoFinal = dineroParaDeposito - dineroParaExtraccion;
		CuentaBancaria cuentaCorrienteBancoProvincia = new CuentaCorriente(limiteDescubierto);
		cuentaCorrienteBancoProvincia.depositar(dineroParaDeposito);
		cuentaCorrienteBancoProvincia.extraer(dineroParaExtraccion);
		Assert.assertTrue(cuentaCorrienteBancoProvincia.getSaldo() == saldoFinal);
	}

	@Test(expected = RuntimeException.class)
	public void extraerConDescubiertoSaldoInsuficiente() {
		// Prueba cuando el limite de descubierto no es suficiente
		final double limiteDescubierto = 1000;
		final double dineroParaDeposito = 500;
		final double dineroDeExtraccion = 5000;
		CuentaBancaria cuentaCorrienteBancoProvincia = new CuentaCorriente(limiteDescubierto);
		cuentaCorrienteBancoProvincia.depositar(dineroParaDeposito);
		cuentaCorrienteBancoProvincia.extraer(dineroDeExtraccion);
	}
}
