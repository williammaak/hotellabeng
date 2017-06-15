package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import dao.implementation.ConsumoDAOImplementation;
import dao.interfaces.ConsumoDAO;
import model.Consumo;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class ConsumoBean {

	private Consumo consumo = new Consumo();
	private List<Consumo> listConsumo = new ArrayList<Consumo>();
	private ConsumoDAO consumoDAO = new ConsumoDAOImplementation();
	private String action;
	
	public void save() {
		try {
			consumoDAO.inserir(consumo);
			FacesUtil.addMessageInfo("Consumo salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}

	public void fetchAll() {
		this.setListConsumo(consumoDAO.listar());
	}

	public void delete(ActionEvent evento) {
		try {
			Consumo entity = (Consumo) evento.getComponent().getAttributes().get("entitySelecionado");
			consumoDAO.remover(entity);
			this.fetchAll();
			FacesUtil.addMessageInfo("Consumo removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}

	public void edit(){
		try {
			this.consumoDAO.atualizar(consumo);

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
					this.consumo = this.consumoDAO.find(Integer.parseInt(id));	
				}
			}
			
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível carregar!");
		}
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public ConsumoDAO getConsumoDAO() {
		return consumoDAO;
	}

	public void setConsumoDAO(ConsumoDAO consumoDAO) {
		this.consumoDAO = consumoDAO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Consumo> getListConsumo() {
		if (listConsumo == null || listConsumo.size() == 0){
			this.fetchAll();
		}
		
		return listConsumo;
	}

	public void setListConsumo(List<Consumo> listConsumo) {
		this.listConsumo = listConsumo;
	}

}