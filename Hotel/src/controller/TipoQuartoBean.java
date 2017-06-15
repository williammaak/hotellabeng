package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import dao.implementation.TipoQuartoDAOImplementation;
import dao.interfaces.TipoQuartoDAO;
import model.TipoQuarto;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class TipoQuartoBean {

	private TipoQuarto tipoQuarto = new TipoQuarto();
	private List<TipoQuarto> listTipoQuarto = new ArrayList<TipoQuarto>();
	private TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAOImplementation();
	private String action;
	
	public void save() {
		try {
			tipoQuartoDAO.inserir(tipoQuarto);
			FacesUtil.addMessageInfo("Tipo de Quarto salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}

	public void fetchAll() {
		this.setListTipoQuarto(tipoQuartoDAO.listar());
	}

	public void delete(ActionEvent evento) {
		try {
			TipoQuarto entity = (TipoQuarto) evento.getComponent().getAttributes().get("entitySelecionado");
			tipoQuartoDAO.remover(entity);
			this.fetchAll();
			FacesUtil.addMessageInfo("Tipo de Quarto removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}

	public void edit(){
		try {
			this.tipoQuartoDAO.atualizar(tipoQuarto);

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
					this.tipoQuarto = this.tipoQuartoDAO.find(Integer.parseInt(id));	
				}
			}
			
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível carregar!");
		}
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public TipoQuartoDAO getTipoQuartoDAO() {
		return tipoQuartoDAO;
	}

	public void setTipoQuartoDAO(TipoQuartoDAO tipoQuartoDAO) {
		this.tipoQuartoDAO = tipoQuartoDAO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<TipoQuarto> getListTipoQuarto() {
		if (listTipoQuarto == null || listTipoQuarto.size() == 0){
			this.fetchAll();
		}
		
		return listTipoQuarto;
	}

	public void setListTipoQuarto(List<TipoQuarto> listTipoQuarto) {
		this.listTipoQuarto = listTipoQuarto;
	}

}