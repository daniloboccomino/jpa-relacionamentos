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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_change_time", updatable = false)
	private Calendar changeTime;
	
	@ManyToOne
	@JoinColumn(name = "cd_user")
	private User user;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "TC_TIP_POSTURE",
				joinColumns = @JoinColumn(name = "cd_posture"),
				inverseJoinColumns = @JoinColumn(name = "cd_tip"))
	private List<Tip> tips;
	
	
	public Posture() {
		super();
	}

	public Posture(Position position) {
		super();
		this.position = position;
	}

	public Posture(int id, Position position) {
		super();
		this.id = id;
		this.position = position;
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public List<Tip> getTips() {
		return tips;
	}

	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}

}
