package Dominio;

public class Cuenta {
	private int noCuenta;
	private int nip;
	private double saldo;
	private Cliente cliente;
	
	public Cuenta() {
	}

	public Cuenta(int noCuenta, int nip, double saldo, Cliente cliente) {
		this.noCuenta = noCuenta;
		this.nip = nip;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [noCuenta=" + noCuenta + ", nip=" + nip + ", saldo=" + saldo + ", cliente=" + cliente + "]\n";
	}

	public int getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(int noCuenta) {
		this.noCuenta = noCuenta;
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
