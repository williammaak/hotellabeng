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
@Table(name = "consumo")
public class Consumo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clienteId", referencedColumnName = "id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "dataHora", nullable = false)
	private Date dataHora;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produtoId", referencedColumnName = "id", nullable = false)
	private Produto produto;
	
	@Column(name = "qtdConsumida", nullable = false)
	private int qtdConsumida;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQtdConsumida() {
		return qtdConsumida;
	}
	public void setQtdConsumida(int qtdConsumida) {
		this.qtdConsumida = qtdConsumida;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
