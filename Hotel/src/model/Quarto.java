package model;

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
@Table(name = "quarto")
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "numQuarto", nullable = false)
	private int numQuarto;
	
	@Column(name = "metragem", nullable = false)
	private double metragem;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoQuartoId", referencedColumnName = "id", nullable = false)
	private TipoQuarto tipoQuarto;
	
	@Column(name = "vlrDiaria", nullable = false)
	private double vlrDiaria;
	
	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	public double getMetragem() {
		return metragem;
	}
	public void setMetragem(double metragem) {
		this.metragem = metragem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	public double getVlrDiaria() {
		return vlrDiaria;
	}
	public void setVlrDiaria(double vlrDiaria) {
		this.vlrDiaria = vlrDiaria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
