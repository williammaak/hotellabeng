package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.implementation.TipoTelefoneDAOImplementation;
import dao.interfaces.TipoTelefoneDAO;
import model.TipoTelefone;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class TipoTelefoneBean {

	TipoTelefone tipoTelefone = new TipoTelefone();
	List<TipoTelefone> tipoTelefones = new ArrayList<TipoTelefone>();
	TipoTelefoneDAO tipoTelefoneDAO = new TipoTelefoneDAOImplementation();
	
	public List<TipoTelefone> getClients() {
		return tipoTelefones;
	}

	public void setClients(List<TipoTelefone> tipoTelefones) {
		this.tipoTelefones = tipoTelefones;
	}

	public TipoTelefoneDAO getClientDAO() {
		return tipoTelefoneDAO;
	}

	public void setClientDAO(TipoTelefoneDAO tipoTelefoneDAO) {
		this.tipoTelefoneDAO = tipoTelefoneDAO;
	}

	public TipoTelefone getClient() {
		return tipoTelefone;
	}

	public void setClient(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
	
	public void save(){
		try {
			tipoTelefoneDAO.inserir(this.tipoTelefone);
			FacesUtil.addMessageInfo("TipoTelefone salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.tipoTelefones = tipoTelefoneDAO.listarTodosOsTipoTelefones();
	}
	
}
