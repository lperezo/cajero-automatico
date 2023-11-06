package Interface;

import Dominio.Cliente;

public interface IMetodosCliente {
	public void guardar(Cliente cliente);
	
	public void editar(Cliente cliente);
	
	public void eliminar(Cliente cliente);
	
	public Cliente buscar(Cliente cliente);
	
	public void listar();
}
