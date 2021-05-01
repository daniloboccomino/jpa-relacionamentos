/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class PostureDaoImpl.java
 * @description: implementacao dao da postura do usuario
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PostureDao;
import br.com.fiap.entity.Posture;

public class PostureDaoImpl extends GenericDaoImpl<Posture, Integer> implements PostureDao {
	
	public PostureDaoImpl(EntityManager em) {
		super(em);
	}

}
