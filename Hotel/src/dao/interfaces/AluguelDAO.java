package dao.interfaces;

import java.util.List;

import model.Aluguel;

public interface AluguelDAO {

	public void inserir(Aluguel c);
	public List<Aluguel> listarTodosOsAluguels();
	public void remover(Aluguel p);
	public void atualizar(Aluguel c);
	
}