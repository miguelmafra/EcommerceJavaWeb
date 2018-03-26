package dal;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Marca;
import model.Marca;
import model.Categoria;
import model.Marca;
import model.Marca;

public class MarcaDAO {

	private static ArrayList<Marca> marcas = new ArrayList<Marca>();

	public static boolean cadastrarMarca(Marca marca) {
		
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		if(buscarMarcaPorNome(marca) == null){
		em.persist(marca);
		em.getTransaction().commit();
		em.close();
		return true;
		}
		return false;
	}

	public static ArrayList<Marca> listarMarcas() {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Marca c");
		ArrayList<Marca> marcasBanco = (ArrayList<Marca>) q.getResultList();
		em.close();

		return marcasBanco;
	}

	public static Marca buscarMarcaPorNome(Marca Marca) {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Marca c WHERE c.nome = :nomeMarca");
		
		q.setParameter("nomeMarca", Marca.getNome());
		ArrayList<Marca> MarcasBanco = (ArrayList<Marca>) q.getResultList();
		em.close();
		
		return MarcasBanco.get(0);
	}

	public static Marca buscarMarcaPorId(int idMarca) {
		EntityManager em = Conexao.getEntityManager();
		Marca c = em.find(Marca.class, idMarca);
		em.close();
		return c;

	}

	public static boolean removerMarca(int idMarca) {
		Marca p = buscarMarcaPorId(idMarca);
		if (p == null) {
			return false;
		}
		marcas.remove(p);
		return true;

	}
	public static boolean removerMarca(Marca marca) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		marca = em.getReference(Marca.class, marca.getId());
		em.remove(marca);
		em.getTransaction().commit();
		em.close();
		return true;
	}
}
