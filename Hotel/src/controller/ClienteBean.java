package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import dao.implementation.ClienteDAOImplementation;
import dao.interfaces.ClienteDAO;
import model.Cliente;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private List<Cliente> listCliente = new ArrayList<Cliente>();
	private ClienteDAO clienteDAO = new ClienteDAOImplementation();
	private String action;
	
	public void save() {
		try {
			clienteDAO.inserir(cliente);
			FacesUtil.addMessageInfo("Cliente salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}

	public void fetchAll() {
		this.setListCliente(clienteDAO.listar());
	}

	public void delete(ActionEvent evento) {
		try {
			Cliente entity = (Cliente) evento.getComponent().getAttributes().get("entitySelecionado");
			clienteDAO.remover(entity);
			this.fetchAll();
			FacesUtil.addMessageInfo("Cliente removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}

	public void edit(){
		try {
			this.clienteDAO.atualizar(cliente);

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
					this.cliente = this.clienteDAO.find(Integer.parseInt(id));	
				}
			}
			
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível carregar!");
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<Cliente> getListCliente() {
		if (listCliente == null || listCliente.size() == 0){
			this.fetchAll();
		}
		
		return listCliente;
	}

	public void setListCliente(List<Cliente> listCliente) {
		this.listCliente = listCliente;
	}

}