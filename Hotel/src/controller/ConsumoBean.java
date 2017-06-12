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
	private List<Consumo> consumos = new ArrayList<Consumo>();
	private ConsumoDAO consumoDAO = new ConsumoDAOImplementation();
	
	public void remover(ActionEvent evento) {
		try {
			Consumo a = (Consumo) evento.getComponent().getAttributes().get("entitySelecionado");
			consumoDAO.remover(a);
			this.fetchAll();
			FacesUtil.addMessageInfo("Consumo removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}
	
	public void save(){
		try {
			getConsumoDAO().inserir(this.getConsumo());
			FacesUtil.addMessageInfo("Consumo salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.setConsumos(getConsumoDAO().listarTodosOsConsumos());
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public List<Consumo> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public ConsumoDAO getConsumoDAO() {
		return consumoDAO;
	}

	public void setConsumoDAO(ConsumoDAO consumoDAO) {
		this.consumoDAO = consumoDAO;
	}
	
}
