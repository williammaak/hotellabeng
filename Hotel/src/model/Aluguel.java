package model;

import java.io.Serializable;
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

import controller.BaseEntity;

@Entity
@Table(name = "aluguel")
public class Aluguel implements BaseEntity, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return String.valueOf(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		
		return ((Aluguel)obj).getId() == id;
	}
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public Long getChaveUnica() {
		return new Long(id);
	}
}
