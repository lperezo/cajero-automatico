package Implementacion;

import java.util.HashMap;

import Dominio.Cliente;
import Interface.IMetodosCliente;

public class ImplementacionCliente implements IMetodosCliente{
	HashMap<Integer, Cliente> hmClientes = new HashMap<Integer, Cliente>();

	@Override
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		hmClientes.put(cliente.getNoCliente(), cliente);
	}

	@Override
	public void editar(Cliente cliente) {
		// TODO Auto-generated method stub
		hmClientes.put(cliente.getNoCliente(), cliente);
	}

	@Override
	public void eliminar(Cliente cliente) {
		// TODO Auto-generated method stub
		hmClientes.remove(cliente.getNoCliente());
	}

	@Override
	public Cliente buscar(Cliente cliente) {
		// TODO Auto-generated method stub
		return hmClientes.get(cliente.getNoCliente());
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		System.out.println(hmClientes);
	}
	
	
}
