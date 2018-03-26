package dal;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;
import model.Venda;

public class VendaDAO {

	private static ArrayList<Venda> vendas = new ArrayList<Venda>();

	public static boolean cadastrarVenda(Venda venda) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		em.merge(venda);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public static ArrayList<Venda> listarVendas() {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Venda c");
		ArrayList<Venda> vendasBanco = (ArrayList<Venda>) q.getResultList();
		em.close();

		return vendasBanco;
	}

}
