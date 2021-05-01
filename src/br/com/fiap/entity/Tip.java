/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class Tip.java
 * @description: entidade no banco que representa as dicas informadas ao usuario baseadas em sua postura
 * @author daniloboccomino - RM85473
 * @since Apr 15, 2021
 */

package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TC_TIP")
@SequenceGenerator(name = "tip", sequenceName = "SQ_TC_TIP", allocationSize = 1)
public class Tip {
	
	@Id
	@Column(name = "cd_tip")
	@GeneratedValue(generator = "tip", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "ds_tip", nullable = false)
	private String tip;
	
	
	public Tip() {
		super();
	}
	
	public Tip(String tip) {
		super();
		this.tip = tip;
	}
	
	public Tip(int id, String tip) {
		super();
		this.id = id;
		this.tip = tip;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}	

}
