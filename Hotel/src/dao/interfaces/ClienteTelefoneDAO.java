package dao.interfaces;

import java.util.List;

import model.ClienteTelefone;

public interface ClienteTelefoneDAO {

	public void inserir(ClienteTelefone c);
	public List<ClienteTelefone> listarTodosOsClienteTelefones();
	public void remover(ClienteTelefone p);
	public void atualizar(ClienteTelefone c);
	
}
