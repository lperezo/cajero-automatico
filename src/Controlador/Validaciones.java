package Controlador;

public class Validaciones {
	public boolean esEntero(String menup) {
		try {
			int ent=Integer.parseInt(menup);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean esCantidadValida(int billete) {
		boolean valido = false;
		if (billete % 10 == 0 && billete >= 20 && billete <= 10000) {
			valido = true;
		} 
		return valido;
	}
	
	public boolean esBilleteValido(int billete) {
		boolean valido = false;
		
		switch (billete) {
			case 1000:
			case 500:
			case 200:
			case 100:
			case 50:
			case 20:
				valido = true;
				break;
			default:
				valido = false;
				break;
		}
		
		return valido;
	}
}
