/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class TipDaoImpl.java
 * @description: implementacao dao de dicas por postura
 * @author daniloboccomino - RM85473
 * @since Apr 15, 2021
 */

package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TipDao;
import br.com.fiap.entity.Tip;

public class TipDaoImpl extends GenericDaoImpl<Tip, Integer> implements TipDao {
	
	public TipDaoImpl(EntityManager em) {
		super(em);
	}

}
