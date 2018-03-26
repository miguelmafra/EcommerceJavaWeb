package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import dal.CategoriaDAO;
import dal.MarcaDAO;
import dal.ProdutoDAO;
import model.Categoria;
import model.Marca;
import model.Produto;

@ManagedBean(name = "mProdutoBean")
public class MProdutoBean {

	private Produto produto = new Produto();
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private int idCategoria;
	private int idMarca;

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public ArrayList<Produto> getProdutos() {
		return ProdutoDAO.listarProdutos();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	// Action
	public String adicionarProduto(Produto p) {
		Categoria c = CategoriaDAO.buscarCategoriaPorId(idCategoria);
		p.setCategoria(c);
		Marca m = MarcaDAO.buscarMarcaPorId(idMarca);
		p.setMarca(m);
		ProdutoDAO.cadastrarProduto(p);
		produto = new Produto();
		return "CadastrarCliente.xhtml?faces-redirect=true";
	}
	
	public String removerProduto (Produto p) {
		ProdutoDAO.removerProduto(p);
		return "ListarProdutos.xhtml?faces-redirect=true";
	}
	
	public String alterarProduto(Produto p) {
		Categoria c = CategoriaDAO.buscarCategoriaPorId(idCategoria);
		p.setCategoria(c);
		Marca m = MarcaDAO.buscarMarcaPorId(idMarca);
		p.setMarca(m);
		ProdutoDAO.cadastrarProduto(p);
		produto = new Produto();
		return "ListarProdutos.xhtml?faces-redirect=true";
	}

}

// Criar a anotação do ManagedBean
// Importar do pacote javax.faces.*
// Criar atributo do modelo
// Criar os getters and setters do atributo