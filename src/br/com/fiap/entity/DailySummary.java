/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class Posture.java
 * @description: entidade no banco que representa o resumo diario do usuario
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TC_DAILY_SUMMARY")
@SequenceGenerator(name = "daily_summary", sequenceName = "SQ_TC_DAILY_SUMMARY", allocationSize = 1)
public class DailySummary {

	@Id
	@Column(name = "cd_daily")
	@GeneratedValue(generator = "daily_summary", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "nr_wrong_posture", nullable = false, scale = 2, precision = 5)
	private double wrongPosture;
	
	@Column(name = "nr_alert_posture", nullable = false, scale = 2, precision = 5)
	private double alertPosture;
	
	@Column(name = "nr_correct_posture", nullable = false, scale = 2, precision = 5)
	private double correctPosture;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_date", updatable = false)
	private Calendar date;
	
	@ManyToOne
	@JoinColumn(name = "cd_user")
	private User user;

	
	public DailySummary() {
		super();
	}
	
	public DailySummary(double wrongPosture, double alertPosture, double correctPosture) {
		super();
		this.wrongPosture = wrongPosture;
		this.alertPosture = alertPosture;
		this.correctPosture = correctPosture;
	}
	
	public DailySummary(int id, double wrongPosture, double alertPosture, double correctPosture) {
		super();
		this.id = id;
		this.wrongPosture = wrongPosture;
		this.alertPosture = alertPosture;
		this.correctPosture = correctPosture;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWrongPosture() {
		return wrongPosture;
	}

	public void setWrongPosture(double wrongPosture) {
		this.wrongPosture = wrongPosture;
	}

	public double getAlertPosture() {
		return alertPosture;
	}

	public void setAlertPosture(double alertPosture) {
		this.alertPosture = alertPosture;
	}

	public double getCorrectPosture() {
		return correctPosture;
	}

	public void setCorrectPosture(double correctPosture) {
		this.correctPosture = correctPosture;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}