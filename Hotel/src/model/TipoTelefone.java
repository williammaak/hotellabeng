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
@Table(name = "tipoTelefone")
public class TipoTelefone implements BaseEntity, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "descTipoTelefone", nullable = false)
	private String descTipoTelefone;
	
	public String getDescTipoTelefone() {
		return descTipoTelefone;
	}
	public void setDescTipoTelefone(String descTipoTelefone) {
		this.descTipoTelefone = descTipoTelefone;
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
		
		return ((TipoTelefone)obj).getId() == id;
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
