package controller;

import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import dal.ItemVendaDAO;
import dal.ProdutoDAO;
import model.ItemVenda;
import model.Produto;

@ManagedBean(name = "mItemVendaBean")

public class MItemVendaBean {

	private ItemVenda itemVenda = new ItemVenda();

	private ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();

	public ArrayList<ItemVenda> getItens() {
		return ItemVendaDAO.listarItemVendas(util.Sessao.verificarSessao());
	}

	private int quantidade = 1;
	
	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}
	
	public int getQuantidade(){
		return quantidade;
	}

	public void setQuantidade(int qtd){
		this.quantidade = qtd;
	}

	// Action
	public String adicionarItemVenda(Produto p) {
		itemVenda.setProduto(ProdutoDAO.buscarProdutoPorId(p.getId()));
		itemVenda.setCarrinhoId(util.Sessao.verificarSessao());
		itemVenda.setQuantidade(p.getQuantidade());
		itemVenda.setDataDaAdicao(Calendar.getInstance());
		ItemVendaDAO.cadastrarItemVenda(itemVenda);
		itemVenda = new ItemVenda();

		return "CarrinhoDeCompras.xhtml?faces-redirect=true";

	}
	
	public String removerItens (ItemVenda i) {
		ItemVendaDAO.removerItemVenda(i);
		return "CarrinhoDeCompras.xhtml?faces-redirect=true";
	}
}