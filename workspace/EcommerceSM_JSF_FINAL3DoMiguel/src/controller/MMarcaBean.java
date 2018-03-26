package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import dal.MarcaDAO;
import dal.MarcaDAO;
import model.Marca;
import model.Marca;

@ManagedBean(name = "mMarcaBean")

public class MMarcaBean {

	private Marca marca = new Marca();

	private ArrayList<Marca> marcas = new ArrayList<Marca>();

	public ArrayList<Marca> getMarcas() {
		return MarcaDAO.listarMarcas();
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	// Action
	public String adicionarMarca(Marca c) {
		MarcaDAO.cadastrarMarca(c);
		marca = new Marca();
		return "CadastrarCategoria.xhtml?faces-redirect=true";

	}

	public String removerMarca(Marca c) {
		MarcaDAO.removerMarca(c);
		return "ListarMarcas.xhtml?faces-redirect=true";
	}

}

// Criar a anotação do ManagedBean
// Importar do pacote javax.faces.*
// Criar atributo do modelo
// Criar os getters and setters do atributo