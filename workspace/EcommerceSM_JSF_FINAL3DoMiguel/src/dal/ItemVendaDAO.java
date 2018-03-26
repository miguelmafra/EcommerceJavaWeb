package dal;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ItemVenda;

public class ItemVendaDAO {

	private static ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();

	public static boolean cadastrarItemVenda(ItemVenda item) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		ItemVenda itemVenda = item;
		em.persist(itemVenda);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public static ArrayList<ItemVenda> listarItemVendas(String carrinhoId) {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT i FROM ItemVenda i WHERE i.carrinhoId = :carrinhoId");
		q.setParameter("carrinhoId", carrinhoId);
		ArrayList<ItemVenda> itensBanco = (ArrayList<ItemVenda>) q.getResultList();
		em.close();

		return itensBanco;
	}
	
	public static ItemVenda buscarItemVendaPorId(int idItemVenda) {
		EntityManager em = Conexao.getEntityManager();
		ItemVenda c = em.find(ItemVenda.class, idItemVenda);
		em.close();
		return c;
	}
	
	public static boolean removerItemVenda(ItemVenda itemVenda) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		itemVenda = em.getReference(ItemVenda.class, itemVenda.getId());
		em.remove(itemVenda);
		em.getTransaction().commit();
		em.close();
		return true;
	}
}
