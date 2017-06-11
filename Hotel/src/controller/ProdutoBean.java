package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.implementation.ProdutoDAOImplementation;
import dao.interfaces.ProdutoDAO;
import model.Produto;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	Produto produto = new Produto();
	List<Produto> produtos = new ArrayList<Produto>();
	ProdutoDAO produtoDAO = new ProdutoDAOImplementation();
	
	public List<Produto> getClients() {
		return produtos;
	}

	public void setClients(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public ProdutoDAO getClientDAO() {
		return produtoDAO;
	}

	public void setClientDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public Produto getClient() {
		return produto;
	}

	public void setClient(Produto produto) {
		this.produto = produto;
	}
	
	public void save(){
		try {
			produtoDAO.inserir(this.produto);
			FacesUtil.addMessageInfo("Produto salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.produtos = produtoDAO.listarTodosOsProdutos();
	}
	
}
