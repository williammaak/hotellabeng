package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoQuarto")
public class TipoQuarto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "descTipoQuarto", nullable = false)
	private String descTipoQuarto;
	
	public String getDescTipoQuarto() {
		return descTipoQuarto;
	}
	public void setDescTipoQuarto(String descTipoQuarto) {
		this.descTipoQuarto = descTipoQuarto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "TipoQuarto[id=" + id + "]";
	}
}
