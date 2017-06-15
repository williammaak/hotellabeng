package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import dao.implementation.QuartoDAOImplementation;
import dao.interfaces.QuartoDAO;
import model.Quarto;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class QuartoBean {

	private Quarto quarto = new Quarto();
	private List<Quarto> listQuarto = new ArrayList<Quarto>();
	private QuartoDAO quartoDAO = new QuartoDAOImplementation();
	private String action;
	
	public void save() {
		try {
			quartoDAO.inserir(quarto);
			FacesUtil.addMessageInfo("Quarto salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}

	public void fetchAll() {
		this.setListQuarto(quartoDAO.listar());
	}

	public void delete(ActionEvent evento) {
		try {
			Quarto entity = (Quarto) evento.getComponent().getAttributes().get("entitySelecionado");
			quartoDAO.remover(entity);
			this.fetchAll();
			FacesUtil.addMessageInfo("Quarto removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}

	public void edit(){
		try {
			this.quartoDAO.atualizar(quarto);

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
					this.quarto = this.quartoDAO.find(Integer.parseInt(id));	
				}
			}
			
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível carregar!");
		}
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public QuartoDAO getQuartoDAO() {
		return quartoDAO;
	}

	public void setQuartoDAO(QuartoDAO quartoDAO) {
		this.quartoDAO = quartoDAO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Quarto> getListQuarto() {
		if (listQuarto == null || listQuarto.size() == 0){
			this.fetchAll();
		}
		
		return listQuarto;
	}

	public void setListQuarto(List<Quarto> listQuarto) {
		this.listQuarto = listQuarto;
	}

}