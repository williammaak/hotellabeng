package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.implementation.FaturaDAOImplementation;
import dao.interfaces.FaturaDAO;
import model.Fatura;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class FaturaBean {

	Fatura fatura = new Fatura();
	List<Fatura> faturas = new ArrayList<Fatura>();
	FaturaDAO faturaDAO = new FaturaDAOImplementation();
	
	public List<Fatura> getClients() {
		return faturas;
	}

	public void setClients(List<Fatura> faturas) {
		this.faturas = faturas;
	}

	public FaturaDAO getClientDAO() {
		return faturaDAO;
	}

	public void setClientDAO(FaturaDAO faturaDAO) {
		this.faturaDAO = faturaDAO;
	}

	public Fatura getClient() {
		return fatura;
	}

	public void setClient(Fatura fatura) {
		this.fatura = fatura;
	}
	
	public void save(){
		try {
			faturaDAO.inserir(this.fatura);
			FacesUtil.addMessageInfo("Fatura salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.faturas = faturaDAO.listarTodosOsFaturas();
	}
	
}
