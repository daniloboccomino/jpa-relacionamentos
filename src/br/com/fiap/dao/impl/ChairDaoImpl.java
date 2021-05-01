/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class ChairDaoImpl.java
 * @description: implementacao dao de cadeira
 * @author daniloboccomino - RM85473
 * @since Apr 17, 2021
 */

package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ChairDao;
import br.com.fiap.entity.Chair;

public class ChairDaoImpl extends GenericDaoImpl<Chair, Integer> implements ChairDao {
	
	public ChairDaoImpl(EntityManager em) {
		super(em);
	}

}
