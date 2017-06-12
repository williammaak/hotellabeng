package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import dao.implementation.ProdutoDAOImplementation;
import dao.interfaces.ProdutoDAO;
import model.Produto;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<Produto>();
	private ProdutoDAO produtoDAO = new ProdutoDAOImplementation();
	
	public void remover(ActionEvent evento) {
		try {
			Produto a = (Produto) evento.getComponent().getAttributes().get("entitySelecionado");
			produtoDAO.remover(a);
			this.fetchAll();
			FacesUtil.addMessageInfo("Produto removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}
	
	public void save(){
		try {
			getProdutoDAO().inserir(this.getProduto());
			FacesUtil.addMessageInfo("Produto salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.setProdutos(getProdutoDAO().listarTodosOsProdutos());
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (produtos == null || produtos.size() == 0) this.fetchAll();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}
	
}
