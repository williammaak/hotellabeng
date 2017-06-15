package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.interfaces.BaseEntity;

@Entity
@Table(name = "produto")
public class Produto implements BaseEntity, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nomeProduto", nullable = false)
	private String nomeProduto;
	
	@Column(name = "vlrUnitario", nullable = false)
	private double vlrUnitario;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public double getVlrUnitario() {
		return vlrUnitario;
	}
	public void setVlrUnitario(double vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
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
		
		return ((Produto)obj).getId() == id;
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
