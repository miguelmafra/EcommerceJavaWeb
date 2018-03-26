package dal;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;
import model.Cliente;

public class ClienteDAO {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public static boolean cadastrarCliente(Cliente cliente) {

		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		if (buscarClientePorNome(cliente) == null) {
			em.persist(cliente);
			em.getTransaction().commit();
			em.close();
			return true;
		}
		return false;
	}

	public static ArrayList<Cliente> listarClientes() {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Cliente c");
		ArrayList<Cliente> clientesBanco = (ArrayList<Cliente>) q.getResultList();
		em.close();

		return clientesBanco;
	}

	public static Cliente buscarClientePorNome(Cliente Cliente) {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nomeCliente");

		q.setParameter("nomeCliente", Cliente.getNome());
		ArrayList<Cliente> ClientesBanco = (ArrayList<Cliente>) q.getResultList();
		em.close();

		return ClientesBanco.get(0);
	}

	public static Cliente buscarClientePorId(int idCliente) {
		EntityManager em = Conexao.getEntityManager();
		Cliente c = em.find(Cliente.class, idCliente);
		em.close();
		return c;

	}

	public static boolean removerCliente(Cliente cliente) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		cliente = em.getReference(Cliente.class, cliente.getId());
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();
		return true;
	}

}
