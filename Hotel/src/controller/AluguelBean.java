package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
	private String action;
	
	public void save() {
		try {
			aluguelDAO.inserir(aluguel);
			FacesUtil.addMessageInfo("Aluguel salvo com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível salvar");
		}
	}

	public void fetchAll() {
		this.alugueis = aluguelDAO.listarTodosOsAluguels();
		
		for (Aluguel a : alugueis) {
			if (a.getCliente() == null) {
				System.out.println("o cliente é nulo");
			}
			else {
				System.out.println(a.getCliente().getId());
			}
		}
	}

	public void remover(ActionEvent evento) {
		try {
			Aluguel a = (Aluguel) evento.getComponent().getAttributes().get("entitySelecionado");
			aluguelDAO.remover(a);
			this.fetchAll();
			FacesUtil.addMessageInfo("Aluguel removido com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível excluir; " + e.toString());
		}
	}

	public void edit(){
		try {
			this.aluguelDAO.atualizar(aluguel);

			FacesUtil.addMessageInfo("Alterado com sucesso");
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível alterar");
		}
	}
	
	public void findOne(){
		try {
			this.action = FacesUtil.getParam("action");
			String id   = FacesUtil.getParam("id");

			System.out.println("AQUI!!!!!!!!!");
			if (id != null){
				this.aluguel = this.aluguelDAO.find(Integer.parseInt(id));	
			}
			
			System.out.println("ID CLIENTE" + this.aluguel.getCliente().getId());
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível carregar!");
		}
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}