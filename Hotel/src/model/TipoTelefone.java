package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoTelefone")
public class TipoTelefone {

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
	
}
