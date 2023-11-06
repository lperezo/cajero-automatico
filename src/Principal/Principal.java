package Principal;

import java.util.Scanner;
import Controlador.Validaciones;
import Dominio.Cliente;
import Dominio.Cuenta;
import Implementacion.ImplementacionCliente;
import Implementacion.ImplementacionCuenta;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noCliente;
		String nombre;
		String app;
		String apm;
		String telefono;
		String correo;
		Cliente cliente;
		
		int noCuenta;
		int nip;
		double saldo;
		Cuenta cuenta;
		
		Scanner lectura = null;
		int menuPrincipal;
		
		ImplementacionCliente impCliente = new ImplementacionCliente();
		ImplementacionCuenta impCuenta = new ImplementacionCuenta();
		Validaciones validacion = new Validaciones();
		
		//variables extras
		String snoCuenta, sNip, sCantDeposito, sCantRetiro;
		
		do {
			System.out.println("\nMENÚ BANCOMER BIENVENIDO");
			System.out.println("1----Alta cliente");
			System.out.println("2----Consultar saldo");
			System.out.println("3----Depositar en efectivo");
			System.out.println("4----Retiro en efectivo");
			System.out.println("5----Salir");
			
			lectura = new Scanner(System.in);
			menuPrincipal = lectura.nextInt();
			
			switch (menuPrincipal) {
			case 1:
				noCliente = (int) ((int) 10000 + Math.random() * 90000);
				noCuenta = (int) ((int) 10000 + Math.random() * 90000);
				
				System.out.println("Ingrese nombre de cliente:");
				lectura = new Scanner(System.in);
				nombre = lectura.nextLine();
				
				System.out.println("Ingrese apellido paterno:");
				lectura = new Scanner(System.in);
				app = lectura.nextLine();
				
				System.out.println("Ingrese apellido materno:");
				lectura = new Scanner(System.in);
				apm = lectura.nextLine();
				
				System.out.println("Ingrese telefono:");
				lectura = new Scanner(System.in);
				telefono = lectura.nextLine();
				
				System.out.println("Ingrese correo:");
				lectura = new Scanner(System.in);
				correo = lectura.nextLine();
				
				cliente = new Cliente(noCliente, nombre, app, apm, telefono, correo);
				impCliente.guardar(cliente);
				
				nip = Integer.parseInt(String.format("%04d", noCuenta % 10000));
				cuenta = new Cuenta(noCuenta, nip, 0, cliente);
				impCuenta.guardar(cuenta);
				
				System.out.println("\nCliente dado de alta con el número de cuenta: "+noCuenta+".\n");
				impCuenta.listar();
				break;
			case 2:
				System.out.println("Ingrese número de cuenta:");
				lectura = new Scanner(System.in);
				snoCuenta = lectura.nextLine();
				
				if (validacion.esEntero(snoCuenta)) {
					noCuenta = Integer.parseInt(snoCuenta);
					
					cuenta = impCuenta.consultarNoCuenta(noCuenta);
					if (cuenta != null) {
						System.out.println("Ingrese NIP:");
						lectura = new Scanner(System.in);
						sNip = lectura.nextLine();
						if (validacion.esEntero(sNip)) {
							nip = Integer.parseInt(sNip);
							if (nip == cuenta.getNip()) {
								System.out.println("======= CONSULTA DE SALDO =======\n No. Cuenta: "+cuenta.getNoCuenta()+
										"|| Cliente:"+cuenta.getCliente().getNoCliente()+" || Saldo actual: "+cuenta.getSaldo());
							}else {
								System.out.println("NIP incorrecto, verifique.");
							}
						}
					} else {
						System.out.println("¡Número de cuenta inexistente!");
					}
				} else {
					System.out.println("Ingrese un número de cuenta válido.");
				}
				
				break;
			case 3:
				System.out.println("======= DEPÓSITO EN EFECTIVO =======");
				System.out.println("Ingrese número de cuenta:");
				lectura = new Scanner(System.in);
				snoCuenta = lectura.nextLine();
				
				if (validacion.esEntero(snoCuenta)) {
					noCuenta = Integer.parseInt(snoCuenta);
					
					cuenta = impCuenta.consultarNoCuenta(noCuenta);
					if (cuenta != null) {
						System.out.println("Ingrese NIP:");
						lectura = new Scanner(System.in);
						sNip = lectura.nextLine();
						if (validacion.esEntero(sNip)) {
							nip = Integer.parseInt(sNip);
							if (nip == cuenta.getNip()) {
								System.out.println("Billetes de 20, 50, 100, 500 y 1000, máximo 10000.");
								System.out.println("Ingrese cantidad a depositar:");
								lectura = new Scanner(System.in);
								sCantDeposito = lectura.nextLine();
								
								if (validacion.esEntero(sCantDeposito) && validacion.esCantidadValida(Integer.parseInt(sCantDeposito))) {
									cliente = cuenta.getCliente();
									cuenta.setSaldo(cuenta.getSaldo()+Double.parseDouble(sCantDeposito));
									System.out.println(impCuenta.consultar(cuenta));
								} else {
									System.out.println("Ingrese una cantidad válida.");
								}
							}else {
								System.out.println("NIP incorrecto, verifique.");
							}
						}
					} else {
						System.out.println("¡Número de cuenta inexistente!");
					}
				} else {
					System.out.println("Ingrese un número de cuenta válido.");
				}
				break;
			case 4:
				System.out.println("======= RETIRO EN EFECTIVO =======");
				System.out.println("Ingrese número de cuenta:");
				lectura = new Scanner(System.in);
				snoCuenta = lectura.nextLine();
				
				if (validacion.esEntero(snoCuenta)) {
					noCuenta = Integer.parseInt(snoCuenta);
					
					cuenta = impCuenta.consultarNoCuenta(noCuenta);
					if (cuenta != null) {
						System.out.println("Ingrese NIP:");
						lectura = new Scanner(System.in);
						sNip = lectura.nextLine();
						if (validacion.esEntero(sNip)) {
							nip = Integer.parseInt(sNip);
							if (nip == cuenta.getNip()) {
								System.out.println("Cantidades en múltiplos de 20, 50, 100, 500 y 1000, máximo 10000.");
								System.out.println("Ingrese cantidad a retirar:");
								lectura = new Scanner(System.in);
								sCantRetiro = lectura.nextLine();
								
								if (validacion.esEntero(sCantRetiro) && validacion.esCantidadValida(Integer.parseInt(sCantRetiro))) {
									cliente = cuenta.getCliente();
									if (!(Integer.parseInt(sCantRetiro) > cuenta.getSaldo())) {
										cliente = cuenta.getCliente();
										cuenta.setSaldo(cuenta.getSaldo()-Double.parseDouble(sCantRetiro));
										System.out.println(impCuenta.consultar(cuenta));
									} else {

									}
								} else {
									System.out.println("Ingrese una cantidad válida.");
								}
							}else {
								System.out.println("NIP incorrecto, verifique.");
							}
						}
					} else {
						System.out.println("¡Número de cuenta inexistente!");
					}
				} else {
					System.out.println("Ingrese un número de cuenta válido.");
				}
				break;
			case 5:
				break;
			}
		} while (menuPrincipal < 5);
	}

}
