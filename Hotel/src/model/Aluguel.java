package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluguel")
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clienteId", referencedColumnName = "id", nullable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "quartoId", referencedColumnName = "id", nullable = false)
	private Quarto quarto;
	
	@Column(name = "dtCheckIn", nullable = false)
	private Date dtCheckIn;
	
	@Column(name = "qtdDias", nullable = false)
	private int qtdDias;
	
	@Column(name = "qtdPessoas", nullable = false)
	private int qtdPessoas;
	
	@Column(name = "indCafeDaManha", nullable = false)
	private boolean indCafeDaManha;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public Date getDtCheckIn() {
		return dtCheckIn;
	}
	public void setDtCheckIn(Date dtCheckIn) {
		this.dtCheckIn = dtCheckIn;
	}
	public int getQtdDias() {
		return qtdDias;
	}
	public void setQtdDias(int qtdDias) {
		this.qtdDias = qtdDias;
	}
	public int getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	public boolean isIndCafeDaManha() {
		return indCafeDaManha;
	}
	public void setIndCafeDaManha(boolean indCafeDaManha) {
		this.indCafeDaManha = indCafeDaManha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
