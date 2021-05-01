/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @interface UserDao.java
 * @description: dao de usuario para implementacao
 * @author daniloboccomino - RM85473
 * @since Apr 14, 2021
 */

package br.com.fiap.dao;

import br.com.fiap.entity.User;

public interface UserDao extends GenericDao<User, Integer> {

}
