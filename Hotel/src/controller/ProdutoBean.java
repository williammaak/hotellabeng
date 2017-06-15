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
	private List<Produto> listProduto = new ArrayList<Produto>();
	private ProdutoDAO produtoDAO = new ProdutoDAOImplementation();
	private String action;
	
	public void save() {
		try {
			produtoDAO.inserir(produto);
			FacesUtil.addMessageInfo("Produto salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}

	public void fetchAll() {
		this.setListProduto(produtoDAO.listar());
	}

	public void delete(ActionEvent evento) {
		try {
			Produto entity = (Produto) evento.getComponent().getAttributes().get("entitySelecionado");
			produtoDAO.remover(entity);
			this.fetchAll();
			FacesUtil.addMessageInfo("Produto removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}

	public void edit(){
		try {
			this.produtoDAO.atualizar(produto);

			FacesUtil.addMessageInfo("Alterado com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível alterar");
		}
	}
	
	public void findOne(){
		try {
			this.action = FacesUtil.getParam("action");
			
			if (!"new".equals(this.action)){
				String id   = FacesUtil.getParam("id");

				if (id != null){
					this.produto = this.produtoDAO.find(Integer.parseInt(id));	
				}
			}
			
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível carregar!");
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}

	public void setProdutoDAO(ProdutoDAO produtoDAO) {
		this.produtoDAO = produtoDAO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Produto> getListProduto() {
		if (listProduto == null || listProduto.size() == 0){
			this.fetchAll();
		}
		
		return listProduto;
	}

	public void setListProduto(List<Produto> listProduto) {
		this.listProduto = listProduto;
	}

}