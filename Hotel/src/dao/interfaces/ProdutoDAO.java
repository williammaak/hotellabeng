package dao.interfaces;

import java.util.List;

import model.Produto;

public interface ProdutoDAO {

	public void inserir(Produto c);
	public List<Produto> listarTodosOsProdutos();
	public void remover(Produto p);
	public void atualizar(Produto c);
	
}
