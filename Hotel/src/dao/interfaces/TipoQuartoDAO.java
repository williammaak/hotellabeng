package dao.interfaces;

import java.util.List;

import model.TipoQuarto;

public interface TipoQuartoDAO {

	public void inserir(TipoQuarto c);
	public List<TipoQuarto> listarTodosOsTipoQuartos();
	public void remover(TipoQuarto p);
	public void atualizar(TipoQuarto c);
	public TipoQuarto find(int id);
	
}
