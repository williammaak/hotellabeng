package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.implementation.ConsumoDAOImplementation;
import dao.interfaces.ConsumoDAO;
import model.Consumo;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class ConsumoBean {

	Consumo consumo = new Consumo();
	List<Consumo> consumos = new ArrayList<Consumo>();
	ConsumoDAO consumoDAO = new ConsumoDAOImplementation();
	
	public List<Consumo> getClients() {
		return consumos;
	}

	public void setClients(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public ConsumoDAO getClientDAO() {
		return consumoDAO;
	}

	public void setClientDAO(ConsumoDAO consumoDAO) {
		this.consumoDAO = consumoDAO;
	}

	public Consumo getClient() {
		return consumo;
	}

	public void setClient(Consumo consumo) {
		this.consumo = consumo;
	}
	
	public void save(){
		try {
			consumoDAO.inserir(this.consumo);
			FacesUtil.addMessageInfo("Consumo salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.consumos = consumoDAO.listarTodosOsConsumos();
	}
	
}
