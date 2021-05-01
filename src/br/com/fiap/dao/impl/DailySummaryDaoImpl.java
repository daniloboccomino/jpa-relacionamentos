/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class DailySummaryDaoImpl.java
 * @description: implementacao dao de resumo diario da postura do usuario
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DailySummaryDao;
import br.com.fiap.entity.DailySummary;

public class DailySummaryDaoImpl extends GenericDaoImpl<DailySummary, Integer> implements DailySummaryDao {
	
	public DailySummaryDaoImpl(EntityManager em) {
		super(em);
	}

}