package Dominio;

public class Cliente {
	private int noCliente;
	private String nombre;
	private String app;
	private String apm;
	private String telefono;
	private String correo;
	
	public Cliente() {
		
	}

	public Cliente(int noCliente, String nombre, String app, String apm, String telefono, String correo) {
		this.noCliente = noCliente;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.telefono = telefono;
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Cliente [noCliente=" + noCliente + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm
				+ ", telefono=" + telefono + ", correo=" + correo + "]\n";
	}

	public int getNoCliente() {
		return noCliente;
	}

	public void setNoCliente(int noCliente) {
		this.noCliente = noCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
