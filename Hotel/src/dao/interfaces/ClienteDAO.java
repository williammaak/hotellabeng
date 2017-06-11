package dao.interfaces;

import java.util.List;

import model.Cliente;

public interface ClienteDAO {
	
	public void inserir(Cliente c);
	public List<Cliente> listarTodosOsClientes();
	public void remover(Cliente p);
	public void atualizar(Cliente c);
	
}