package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import dao.implementation.QuartoDAOImplementation;
import dao.interfaces.QuartoDAO;
import model.Quarto;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class QuartoBean {

	private Quarto quarto = new Quarto();
	private List<Quarto> quartos = new ArrayList<Quarto>();
	private QuartoDAO quartoDAO = new QuartoDAOImplementation();
	
	public void remover(ActionEvent evento) {
		try {
			Quarto a = (Quarto) evento.getComponent().getAttributes().get("entitySelecionado");
			quartoDAO.remover(a);
			this.fetchAll();
			FacesUtil.addMessageInfo("Quarto removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}
	
	public List<SelectItem> getQuartosComboBox(){
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		try {
			this.fetchAll();
			for (Quarto c : quartos) {
				list.add(new SelectItem(c, c.getNumQuarto() + " - " + c.getDescricao()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public void save(){
		try {
			quartoDAO.inserir(this.quarto);
			FacesUtil.addMessageInfo("Quarto salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}
	
	public void fetchAll(){
		this.quartos = quartoDAO.listarTodosOsQuartos();
	}
	
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public List<Quarto> getQuartos() {
		if (quartos == null || quartos.size() == 0) this.fetchAll();
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	public QuartoDAO getQuartoDAO() {
		return quartoDAO;
	}

	public void setQuartoDAO(QuartoDAO quartoDAO) {
		this.quartoDAO = quartoDAO;
	}
}
