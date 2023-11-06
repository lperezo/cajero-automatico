package Interface;

import Dominio.Cuenta;

public interface IMetodosCuenta {
	
	public void guardar(Cuenta cuenta);
	
	public Cuenta consultar(Cuenta cuenta);
	
	public void depositar(Cuenta cuenta, double cantidad);
	
	public void retirar(Cuenta cuenta, double cantidad);
	
	public void listar();
}
