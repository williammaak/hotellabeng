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
	private List<Aluguel> listAluguel = new ArrayList<Aluguel>();
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
		this.setListAluguel(aluguelDAO.listar());
	}

	public void delete(ActionEvent evento) {
		try {
			Aluguel entity = (Aluguel) evento.getComponent().getAttributes().get("entitySelecionado");
			aluguelDAO.remover(entity);
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
			
			if (!"new".equals(this.action)){
				String id   = FacesUtil.getParam("id");

				if (id != null){
					this.aluguel = this.aluguelDAO.find(Integer.parseInt(id));	
				}
			}
			
		} catch (Exception e) {
			FacesUtil.addMessageInfo("Não foi possível carregar!");
		}
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

	public List<Aluguel> getListAluguel() {
		if (listAluguel == null || listAluguel.size() == 0){
			this.fetchAll();
		}
		
		return listAluguel;
	}

	public void setListAluguel(List<Aluguel> listAluguel) {
		this.listAluguel = listAluguel;
	}

}