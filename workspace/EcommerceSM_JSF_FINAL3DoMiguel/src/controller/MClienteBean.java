package controller;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dal.ClienteDAO;
import model.Cliente;

@ManagedBean(name = "mClienteBean")

public class MClienteBean {

	private Cliente cliente = new Cliente();

	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public ArrayList<Cliente> getClientes() {
		return ClienteDAO.listarClientes();
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// Action
	public String adicionarCliente(Cliente c) {
		ClienteDAO.cadastrarCliente(c);
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente cadastrado com sucesso!", ""));
		cliente = new Cliente();
		return "AreaComercial.xhtml?faces-redirect=true";
	}

	public String removerCliente(Cliente p) {
		ClienteDAO.removerCliente(p);
		return "ListarClientes.xhtml?faces-redirect=true";
	}

}

// Criar a anotação do ManagedBean
// Importar do pacote javax.faces.*
// Criar atributo do modelo
// Criar os getters and setters do atributo