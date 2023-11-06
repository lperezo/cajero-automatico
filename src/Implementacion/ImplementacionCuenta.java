package Implementacion;

import java.util.HashMap;

import Dominio.Cuenta;
import Interface.IMetodosCuenta;

public class ImplementacionCuenta implements IMetodosCuenta{
	HashMap<Integer, Cuenta> hmCuentas = new HashMap<Integer, Cuenta>();

	@Override
	public void guardar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		hmCuentas.put(cuenta.getNoCuenta(), cuenta);
	}

	@Override
	public Cuenta consultar(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return hmCuentas.get(cuenta.getNoCuenta());
	}

	@Override
	public void depositar(Cuenta cuenta, double cantidad) {
		// TODO Auto-generated method stub
		hmCuentas.put(cuenta.getNoCuenta(), cuenta);
	}

	@Override
	public void retirar(Cuenta cuenta, double cantidad) {
		// TODO Auto-generated method stub
		hmCuentas.put(cuenta.getNoCuenta(), cuenta);
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		System.out.println(hmCuentas);
	}
	
	// Consultar por número de cuenta
	public Cuenta consultarNoCuenta(int noCuenta) {
		// TODO Auto-generated method stub
		return hmCuentas.get(noCuenta);
	}
}
