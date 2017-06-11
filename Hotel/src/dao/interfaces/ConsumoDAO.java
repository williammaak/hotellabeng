package dao.interfaces;

import java.util.List;

import model.Consumo;

public interface ConsumoDAO {

	public void inserir(Consumo c);
	public List<Consumo> listarTodosOsConsumos();
	public void remover(Consumo p);
	public void atualizar(Consumo c);
	
}
