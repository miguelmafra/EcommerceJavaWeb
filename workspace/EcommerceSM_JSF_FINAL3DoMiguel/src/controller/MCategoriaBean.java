package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import dal.CategoriaDAO;
import model.Categoria;


@ManagedBean(name = "mCategoriaBean")

public class MCategoriaBean {

	private Categoria categoria = new Categoria();

	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();

	public ArrayList<Categoria> getCategorias() {
		return CategoriaDAO.listarCategorias();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Action
	public String adicionarCategoria(Categoria c) {
		CategoriaDAO.cadastrarCategoria(c);
		categoria = new Categoria();
		return "CadastrarProduto.xhtml?faces-redirect=true";
	}
	
	public String removerCategoria (Categoria c) {
		CategoriaDAO.removerCategoria(c);
		categoria = new Categoria();
		return "ListarCategorias.xhtml?faces-redirect=true";
	}

}

// Criar a anotação do ManagedBean
// Importar do pacote javax.faces.*
// Criar atributo do modelo
// Criar os getters and setters do atributo