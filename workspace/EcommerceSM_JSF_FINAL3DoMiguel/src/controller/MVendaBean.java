package controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;

import dal.ClienteDAO;
import dal.ItemVendaDAO;
import dal.VendaDAO;
import model.Cliente;
import model.ItemVenda;
import model.Venda;

@ManagedBean(name = "mVendaBean")

public class MVendaBean {

	private Venda venda = new Venda();

	private int idItemVenda;
	
	private int idCliente;

	private ArrayList<Venda> vendas = new ArrayList<Venda>();	

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public ArrayList<Venda> getVendas() {
		return VendaDAO.listarVendas();
	}

	public int getIdItemVenda() {
		return idItemVenda;
	}

	public void setIdItemVenda(int idItemVenda) {
		this.idItemVenda = idItemVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	// Action
	public String adicionarVenda() {
		venda = new Venda();
		ArrayList<ItemVenda> itens = ItemVendaDAO.listarItemVendas(util.Sessao.verificarSessao());
		double valorVenda = 0;
		for (int i = 0; i < itens.size(); i++) {
			valorVenda = itens.get(i).getQuantidade() * (itens.get(i).getProduto().getPreco());
		}
		venda.setDataDaVenda(Calendar.getInstance());
		venda.setValorDaVenda(valorVenda);
		venda.setItens(itens);
		Cliente c = ClienteDAO.buscarClientePorId(idCliente);
		venda.setCliente(c);
		VendaDAO.cadastrarVenda(venda);
		venda = new Venda();
		return "CarrinhoDeCompras.xhtml?faces-redirect=true";

	}
}