package com.cuentasbancarias.entidadesTest;

import com.cuentasbancarias.entidades.*;
import org.junit.Assert;
import org.junit.Test;

public class CajaDeAhorroTest {

	@Test
	public void DepositoEnCuenta() {
		CuentaBancaria cajaBancoProvincia = new CajaDeAhorro();
		final double saldo = 2000;
		cajaBancoProvincia.depositar(saldo);
		Assert.assertTrue(saldo == cajaBancoProvincia.getSaldo());
	}

	@Test
	public void ExtraerDeCuenta() {
		CuentaBancaria cajaBancoProvincia = new CajaDeAhorro();
		final double saldo = 2000;
		cajaBancoProvincia.depositar(saldo);
		final double dineroDeExtraccion = 1000;
		final double dineroFinalEnCuenta = cajaBancoProvincia.getSaldo() - dineroDeExtraccion;
		cajaBancoProvincia.extraer(dineroDeExtraccion);
		Assert.assertTrue(dineroFinalEnCuenta == (cajaBancoProvincia.getSaldo()));
	}
}
