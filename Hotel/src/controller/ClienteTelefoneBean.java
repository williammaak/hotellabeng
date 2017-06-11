package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.implementation.ClienteTelefoneDAOImplementation;
import dao.interfaces.ClienteTelefoneDAO;
import model.ClienteTelefone;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteTelefoneBean {

	ClienteTelefone clienteTelefone = new ClienteTelefone();
	List<ClienteTelefone> clienteTelefones = new ArrayList<ClienteTelefone>();
	ClienteTelefoneDAO clienteTelefoneDAO = new ClienteTelefoneDAOImplementation();
	
	public List<ClienteTelefone> getClients() {
		return clienteTelefones;
	}

	public void setClients(List<ClienteTelefone> clienteTelefones) {
		this.clienteTelefones = clienteTelefones;
	}

	public ClienteTelefoneDAO getClientDAO() {
		return clienteTelefoneDAO;
	}

	public void setClientDAO(ClienteTelefoneDAO clienteTelefoneDAO) {
		this.clienteTelefoneDAO = clienteTelefoneDAO;
	}

	public ClienteTelefone getClient() {
		return clienteTelefone;
	}

	public void setClient(ClienteTelefone clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}
	
	public void save(){
		try {
			clienteTelefoneDAO.inserir(this.clienteTelefone);
			FacesUtil.addMessageInfo("ClienteTelefone salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.clienteTelefones = clienteTelefoneDAO.listarTodosOsClienteTelefones();
	}
	
}
