/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class User.java
 * @description: entidade no banco que representa um usuario da aplicacao
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TC_USER")
@SequenceGenerator(name = "user", sequenceName = "SQ_TC_USER", allocationSize = 1)
public class User {
	
	@Id
	@Column(name = "cd_user")
	@GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "ds_email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "ds_password", nullable = false, length = 100)
	private String password;
	
	@Column(name = "nr_cpf", nullable = false, length = 14)
	private String cpf;
	
	@Column(name = "nr_phone", nullable = false, length = 20)
	private String phone;
	
	@Column(name = "nm_name", nullable = false, length = 100)
	private String name;
	
	@Column(name="ds_gender", length = 20)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	/*
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Posture posture;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private DailySummary dailySummary;
	*/
	
	
	public User() {
		super();
	}

	public User(String email, String password, String cpf, String phone, String name, Gender gender) {
		super();
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.phone = phone;
		this.name = name;
		this.gender = gender;
	}

	public User(int id, String email, String password, String cpf, String phone, String name, Gender gender) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.phone = phone;
		this.name = name;
		this.gender = gender;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
