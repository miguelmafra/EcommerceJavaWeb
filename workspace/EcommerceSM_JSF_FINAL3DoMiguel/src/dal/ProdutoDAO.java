package dal;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Produto;
import model.Categoria;
import model.Marca;
import model.Produto;

public class ProdutoDAO {

	private static ArrayList<Produto> produtos = new ArrayList<Produto>();

	public static boolean cadastrarProduto(Produto produto) {
		
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		if(buscarProdutoPorNome(produto) == null){
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
		return true;
		}
		return false;
	}

	public static ArrayList<Produto> listarProdutos() {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Produto c");
		ArrayList<Produto> produtosBanco = (ArrayList<Produto>) q.getResultList();
		em.close();

		return produtosBanco;
	}

	public static Produto buscarProdutoPorNome(Produto Produto) {
		EntityManager em = Conexao.getEntityManager();
		Query q = em.createQuery("SELECT c FROM Produto c WHERE c.nome = :nomeProduto");
		
		q.setParameter("nomeProduto", Produto.getNome());
		ArrayList<Produto> ProdutosBanco = (ArrayList<Produto>) q.getResultList();
		em.close();
		
		return ProdutosBanco.get(0);
	}

	public static Produto buscarProdutoPorId(int idProduto) {
		EntityManager em = Conexao.getEntityManager();
		Produto c = em.find(Produto.class, idProduto);
		em.close();
		return c;

	}

	public static boolean removerProduto(Produto produto) {
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		produto = em.getReference(Produto.class, produto.getId());
		em.remove(produto);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	public static ArrayList<Produto> retornarProdutosPorMarca(Marca marca) {
		ArrayList<Produto> arrayAuxiliar = new ArrayList<Produto>();

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getMarca() == marca) {
				arrayAuxiliar.add(produtos.get(i));
			}
		}

		return arrayAuxiliar;

	}

	public static ArrayList<Produto> retornarProdutosPorCategoria(Categoria categoria) {
		ArrayList<Produto> arrayAuxiliar = new ArrayList<Produto>();

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getCategoria() == categoria) {
				arrayAuxiliar.add(produtos.get(i));
			}
		}

		return arrayAuxiliar;

	}

}
