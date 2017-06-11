package dao.interfaces;

import java.util.List;

import model.Fatura;

public interface FaturaDAO {

	public void inserir(Fatura c);
	public List<Fatura> listarTodosOsFaturas();
	public void remover(Fatura p);
	public void atualizar(Fatura c);
	
}
