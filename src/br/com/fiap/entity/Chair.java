/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class Chair.java
 * @description: entidade no banco que representa o modelo da cadeira
 * @author daniloboccomino - RM85473
 * @since Apr 17, 2021
 */

package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TC_CHAIR")
@SequenceGenerator(name = "chair", sequenceName = "SQ_TC_CHAIR", allocationSize = 1)
public class Chair {
	
	@Id
	@Column(name = "cd_chair")
	@GeneratedValue(generator = "chair", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "nm_brand", nullable = false, length = 100)
	private String brand;
	
	@Column(name = "nm_model", nullable = false, length = 100)
	private String model;
	
	@OneToOne(mappedBy = "chair", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private User user;
	
	
	public Chair() {
		super();
	}

	public Chair(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}

	public Chair(int id, String brand, String model) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
