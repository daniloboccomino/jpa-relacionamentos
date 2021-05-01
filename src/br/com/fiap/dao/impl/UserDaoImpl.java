/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class UserDaoImpl.java
 * @description: implementacao dao de usuario
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.UserDao;
import br.com.fiap.entity.User;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
	
	public UserDaoImpl(EntityManager em) {
		super(em);
	}

}
