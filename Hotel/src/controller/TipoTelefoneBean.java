package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import dao.implementation.TipoTelefoneDAOImplementation;
import dao.interfaces.TipoTelefoneDAO;
import model.TipoTelefone;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class TipoTelefoneBean {

	private TipoTelefone tipoTelefone = new TipoTelefone();
	private List<TipoTelefone> tipoTelefones = new ArrayList<TipoTelefone>();
	private TipoTelefoneDAO tipoTelefoneDAO = new TipoTelefoneDAOImplementation();
	
	public void remover(ActionEvent evento) {
		try {
			TipoTelefone a = (TipoTelefone) evento.getComponent().getAttributes().get("entitySelecionado");
			tipoTelefoneDAO.remover(a);
			this.fetchAll();
			FacesUtil.addMessageInfo("Telefone removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}
	public void save(){
		try {
			getTipoTelefoneDAO().inserir(this.getTipoTelefone());
			FacesUtil.addMessageInfo("TipoTelefone salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.setTipoTelefones(getTipoTelefoneDAO().listarTodosOsTipoTelefones());
	}

	public List<TipoTelefone> getTipoTelefones() {
		return tipoTelefones;
	}

	public void setTipoTelefones(List<TipoTelefone> tipoTelefones) {
		this.tipoTelefones = tipoTelefones;
	}

	public TipoTelefoneDAO getTipoTelefoneDAO() {
		return tipoTelefoneDAO;
	}

	public void setTipoTelefoneDAO(TipoTelefoneDAO tipoTelefoneDAO) {
		this.tipoTelefoneDAO = tipoTelefoneDAO;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
}
