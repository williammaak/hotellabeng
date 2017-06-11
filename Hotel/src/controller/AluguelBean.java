package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.implementation.AluguelDAOImplementation;
import dao.interfaces.AluguelDAO;
import model.Aluguel;
import util.FacesUtil;

@ManagedBean
@ViewScoped
public class AluguelBean {

	private Aluguel aluguel = new Aluguel();
	private List<Aluguel> alugueis = new ArrayList<Aluguel>();
	private AluguelDAO aluguelDAO = new AluguelDAOImplementation();

	public void save() {
		try {
			getAluguelDAO().inserir(this.getAluguel());
			FacesUtil.addMessageInfo("Aluguel salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}

	public void fetchAll() {
		this.setAlugueis(getAluguelDAO().listarTodosOsAluguels());
	}

	public String remover(Aluguel c) {
		try {
			this.aluguel = c;
			aluguelDAO.remover(c);
			FacesUtil.addMessageInfo("Aluguel removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir");
		}
		return "list.xhtml";
	}

	public String alterar(Aluguel c) {
		this.aluguel = c;
		return "post.xhtml?faces-redirect=true";
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public AluguelDAO getAluguelDAO() {
		return aluguelDAO;
	}

	public void setAluguelDAO(AluguelDAO aluguelDAO) {
		this.aluguelDAO = aluguelDAO;
	}

}
