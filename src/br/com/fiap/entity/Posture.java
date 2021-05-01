/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class Posture.java
 * @description: entidade no banco que representa a postura do usuario
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TC_POSTURE")
@SequenceGenerator(name = "posture", sequenceName = "SQ_TC_POSTURE", allocationSize = 1)
public class Posture {
	
	@Id
	@Column(name = "cd_posture")
	@GeneratedValue(generator = "posture", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "ds_position", nullable = false, length = 50)
	@Enumerated(EnumType.STRING)
	private Position position;
	
	@Column(name = "dt_change_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Calendar changeTime;
	
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_user", nullable = false)
	*/
	@Column(name = "nm_name", nullable = false, length = 100)
	private String user;
	
	
	public Posture() {
		super();
	}

	public Posture(Position position, String user) {
		super();
		this.position = position;
		this.user = user;
	}

	public Posture(int id, Position position, String user) {
		super();
		this.id = id;
		this.position = position;
		this.user = user;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Calendar getChangeTime() {
		return changeTime;
	}
	
	public void setChangeTime(Calendar changeTime) {
		this.changeTime = changeTime;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

}
