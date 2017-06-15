package dao.interfaces;

import java.util.List;

import model.Quarto;

public interface QuartoDAO {

	public void inserir(Quarto c);
	public List<Quarto> listar();
	public void remover(Quarto p);
	public void atualizar(Quarto c);
	public Quarto find(int id);
	
}
