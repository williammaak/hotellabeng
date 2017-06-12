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

	Cliente cliente = new Cliente();
	List<Cliente> clientes = new ArrayList<Cliente>();
	ClienteDAO clienteDAO = new ClienteDAOImplementation();
	
	public void remover(ActionEvent evento) {
		try {
			Cliente a = (Cliente) evento.getComponent().getAttributes().get("entitySelecionado");
			clienteDAO.remover(a);
			this.fetchAll();
			FacesUtil.addMessageInfo("Cliente removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}
	
	public void save(){
		try {
			clienteDAO.inserir(this.cliente);
			FacesUtil.addMessageInfo("Cliente salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.clientes = clienteDAO.listarTodosOsClientes();
	}
	
	public String remover(Cliente c){
		try {
			this.cliente = c;
			clienteDAO.remover(c);
			FacesUtil.addMessageInfo("Cliente removido com sucesso");
		} catch (Exception e){
			FacesUtil.addMessageInfo("Não foi possível excluir");
		}
		return "list.xhtml";
	}
	
	public String alterar(Cliente c) {
		this.cliente = c;
		return "post.xhtml?faces-redirect=true";
	}
	
	public List<Cliente> getClientes() {
		if (clientes == null || clientes.size() == 0) this.fetchAll();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ClienteDAO getClientDAO() {
		return clienteDAO;
	}

	public void setClientDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
