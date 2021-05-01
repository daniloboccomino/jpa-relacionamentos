/**
 * Enterprise Application Development
 * FIAP - Faculdade de Informática e Administração Paulista
 * Professor Thiago Toshiyuki I. Yamamoto
 *
 * @class MainCrudTest.java
 * @description: teste crud das entidades no banco
 * @author daniloboccomino - RM85473
 * @since Apr 16, 2021
 */

package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.EntityManagerFactorySingleton;
import br.com.fiap.dao.ChairDao;
import br.com.fiap.dao.DailySummaryDao;
import br.com.fiap.dao.PostureDao;
import br.com.fiap.dao.TipDao;
import br.com.fiap.dao.UserDao;
import br.com.fiap.dao.impl.ChairDaoImpl;
import br.com.fiap.dao.impl.DailySummaryDaoImpl;
import br.com.fiap.dao.impl.PostureDaoImpl;
import br.com.fiap.dao.impl.TipDaoImpl;
import br.com.fiap.dao.impl.UserDaoImpl;
import br.com.fiap.entity.Chair;
import br.com.fiap.entity.DailySummary;
import br.com.fiap.entity.Gender;
import br.com.fiap.entity.Position;
import br.com.fiap.entity.Posture;
import br.com.fiap.entity.Tip;
import br.com.fiap.entity.User;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntityNotFoundException;

public class MainCrudTest {

	public static void main(String[] args) {
		
		// obter o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		UserDao userDao = new UserDaoImpl(em);
		PostureDao postureDao = new PostureDaoImpl(em);
		DailySummaryDao dailyDao = new DailySummaryDaoImpl(em);
		TipDao tipDao = new TipDaoImpl(em);
		ChairDao chairDao = new ChairDaoImpl(em);
		
		// insert user
		User user = new User(
							"rm85473@fiap.com.br",
							"85473",
							"12345678911",
							"11900000000",
							"Danilo",
							Gender.MASCULINO
							);
		try {
			userDao.insert(user);
			userDao.commit();
			System.out.println("Usuário cadastrado.");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// insert posture
		Posture posture = new Posture(Position.CORRECT, "Danilo");
		try {
			postureDao.insert(posture);
			postureDao.commit();
			System.out.println("Postura cadastrada.");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// insert summary
		DailySummary daily = new DailySummary(8d, 14d, 78d, "Danilo");
		try {
			dailyDao.insert(daily);
			dailyDao.commit();
			System.out.println("Resumo diário cadastrado.");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// insert tip
		Tip tip = new Tip("Encostar corretamente a lombar e ombros na cadeira.");
		try {
			tipDao.insert(tip);
			tipDao.commit();
			System.out.println("Dica cadastrada.");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// insert chair
		Chair chair = new Chair("Pichau", "Gaming");
		try {
			chairDao.insert(chair);
			chairDao.commit();
			System.out.println("Cadeira cadastrada.");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		// auxiliar variable 
		int id = user.getId();
		
		
		// select
		try {
			user = userDao.select(id);
			System.out.println("User: " + user.getName()
						  + " | Email: " + user.getEmail()
						  + " | Phone: " + user.getPhone()
						  + " | Gender: " + user.getGender());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// update
		try {
			user = new User(
							id,
							"rm85473@fiap.com.br",
							"rm85473",
							"12345678911",
							"11999999999",
							"Danilo Boccomino",
							Gender.MASCULINO
							);
			userDao.update(user);
			userDao.commit();
			System.out.println("Usuário atualizado.");
			System.out.println("User: " + user.getName()
						  + " | Email: " + user.getEmail()
						  + " | Gender: " + user.getGender()
						  + " | Phone: " + user.getPhone());
		} catch (CommitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
				
		// delete
		if (id - 1 > 1) {
			try {
				userDao.delete(id-1);
				postureDao.delete(id-1);
				dailyDao.delete(id-1);
				tipDao.delete(id-1);
				userDao.commit();
				System.out.println("Usuário removido.");
			} catch (CommitException | EntityNotFoundException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		// fechar conexao
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
