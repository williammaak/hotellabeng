package dao.interfaces;

import java.util.List;

import model.Cliente;

public interface ClienteDAO {

	public void inserir(Cliente c);
	public List<Cliente> listar();
	public void remover(Cliente p);
	public void atualizar(Cliente c);
	public Cliente find(int id);
	
}
