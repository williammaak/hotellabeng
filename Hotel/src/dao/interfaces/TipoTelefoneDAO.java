package dao.interfaces;

import java.util.List;

import model.TipoTelefone;

public interface TipoTelefoneDAO {

	public void inserir(TipoTelefone c);
	public List<TipoTelefone> listarTodosOsTipoTelefones();
	public void remover(TipoTelefone p);
	public void atualizar(TipoTelefone c);
	
}
