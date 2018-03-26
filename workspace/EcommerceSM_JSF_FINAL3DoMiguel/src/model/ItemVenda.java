package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ItemVenda implements Serializable {
	public ItemVenda(){
		produto = new Produto();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Produto produto;
	private int quantidade;
	private Calendar dataDaAdicao;
	private String carrinhoId;
	
	public String getCarrinhoId() {
		return carrinhoId;
	}
	public void setCarrinhoId(String carrinhoId) {
		this.carrinhoId = carrinhoId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Calendar getDataDaAdicao() {
		return dataDaAdicao;
	}
	public void setDataDaAdicao(Calendar dataDaAdicao) {
		this.dataDaAdicao = dataDaAdicao;
	}

}
