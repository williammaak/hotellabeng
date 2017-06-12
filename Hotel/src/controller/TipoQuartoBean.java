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
	private List<TipoQuarto> tipoQuartos = new ArrayList<TipoQuarto>();
	private TipoQuartoDAO tipoQuartoDAO = new TipoQuartoDAOImplementation();
		
	public void remover(ActionEvent evento) {
		try {
			TipoQuarto a = (TipoQuarto) evento.getComponent().getAttributes().get("entitySelecionado");
			tipoQuartoDAO.remover(a);
			this.fetchAll();
			FacesUtil.addMessageInfo("Quarto removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}
	public List<TipoQuarto> getTipoQuartosComboBox(){
		this.fetchAll();
		return tipoQuartos;
	}
	
	public String remover(TipoQuarto c){
		try {
			this.tipoQuarto = c;
			tipoQuartoDAO.remover(c);
			FacesUtil.addMessageInfo("TipoQuarto removido com sucesso");
		} catch (Exception e){
			FacesUtil.addMessageInfo("Não foi possível excluir");
		}
		return "list.xhtml";
	}
	
	public String alterar(TipoQuarto c) {
		this.tipoQuarto = c;
		return "post.xhtml?faces-redirect=true";
	}
	
	public void save(){
		try {
			getTipoQuartoDAO().inserir(this.getTipoQuarto());
			FacesUtil.addMessageInfo("TipoQuarto salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.setTipoQuartos(getTipoQuartoDAO().listarTodosOsTipoQuartos());
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public List<TipoQuarto> getTipoQuartos() {
		return tipoQuartos;
	}

	public void setTipoQuartos(List<TipoQuarto> tipoQuartos) {
		this.tipoQuartos = tipoQuartos;
	}

	public TipoQuartoDAO getTipoQuartoDAO() {
		return tipoQuartoDAO;
	}

	public void setTipoQuartoDAO(TipoQuartoDAO tipoQuartoDAO) {
		this.tipoQuartoDAO = tipoQuartoDAO;
	}
	
}
