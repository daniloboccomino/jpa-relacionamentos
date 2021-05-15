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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.dao.impl.GenericDaoImpl;
import br.com.fiap.entity.Chair;
import br.com.fiap.entity.DailySummary;
import br.com.fiap.entity.Gender;
import br.com.fiap.entity.Position;
import br.com.fiap.entity.Posture;
import br.com.fiap.entity.Tip;
import br.com.fiap.entity.User;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class MainCrudTest {

	public static void main(String[] args) {
			
		// instanciar os usuarios
		User u1 = new User(
							"rm85473@fiap.com.br",
							"85473",
							"12345678911",
							"11900000000",
							"Danilo",
							Gender.MASCULINO
							);

		User u2 = new User(
							"rm85555@fiap.com.br",
							"85555",
							"12345678911",
							"11900000000",
							"Felipe",
							Gender.MASCULINO
							);
		
		User u3 = new User(
							"rm85542@fiap.com.br",
							"85542",
							"12345678911",
							"11900000000",
							"Giovanna",
							Gender.FEMININO
							);
		
		User u4 = new User(
							"rm83448@fiap.com.br",
							"83448",
							"12345678911",
							"11900000000",
							"Gustavo",
							Gender.MASCULINO
							);
		
		User u5 = new User(
							"rm85634@fiap.com.br",
							"85634",
							"12345678911",
							"11900000000",
							"Murilo",
							Gender.MASCULINO
							);
		
		// instanciar as cadeiras
		Chair c1 = new Chair("Pichau", "Gaming");
		Chair c2 = new Chair("Madison", "Presidente");
		Chair c3 = new Chair("Herman Miller", "Aeron Mineral");
		Chair c4 = new Chair("DT3sports", "Elise");
		Chair c5 = new Chair("DXRacer", "Origin");
		
		// adicionar as cadeiras aos usuarios
		u1.setChair(c1);
		u2.setChair(c2);
		u3.setChair(c3);
		u4.setChair(c4);
		u5.setChair(c5);

		// instanciar as dicas
		Tip t1 = new Tip("Postura adequada. Manter posição para evitar dores e lesões.");
		Tip t2 = new Tip("Lembrar de apoiar a lombar para melhor conforto.");
		Tip t3 = new Tip("Encostar corretamente a lombar e ombros na cadeira.");
		
		List<Tip> tips = new ArrayList<>();
		
		// instanciar as posturas
		tips.add(t1);
		Posture p1 = new Posture(Position.CORRECT);
		p1.setTips(tips);
		
		tips.add(t2);
		Posture p2 = new Posture(Position.ALERT);
		p2.setTips(tips);
		
		tips.add(t3);
		Posture p3 = new Posture(Position.WRONG);
		p3.setTips(tips);
		
		// adicionar as posturas aos usuarios
		u1.addPosture(p1);
		u2.addPosture(p1);
		u3.addPosture(p2);
		u4.addPosture(p2);
		u5.addPosture(p3);

		// instanciar os resumos diarios
		DailySummary d1 = new DailySummary(8d, 14d, 78d);
		
		// adicionar os resumos diarios ao usuario
		u1.addDailySummary(d1);
		u2.addDailySummary(d1);
		u3.addDailySummary(d1);
		u4.addDailySummary(d1);
		u5.addDailySummary(d1);
		
		// obter o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		GenericDao<User, Integer> dao = new GenericDaoImpl<User, Integer>(em) {};
		
		try {
			// cadastrar os usuários
			dao.insert(u1);
			dao.insert(u2);
			dao.insert(u3);
			dao.insert(u4);
			dao.insert(u5);
			dao.commit();
			System.out.println("Cadastro realizado com sucesso.");
			
		} catch (CommitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// fechar conexao
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
