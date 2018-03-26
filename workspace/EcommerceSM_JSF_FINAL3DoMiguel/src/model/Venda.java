package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda implements Serializable{
	public Venda() {
		cliente = new Cliente();
		itens = new ArrayList<ItemVenda>();
		dataDaVenda = Calendar.getInstance();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double valorDaVenda;
	@Temporal(TemporalType.DATE)
	private Calendar dataDaVenda;
	@ManyToOne
	private Cliente cliente;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemVenda> itens; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}
	public double getValorDaVenda() {
		return valorDaVenda;
	}
	public void setValorDaVenda(double valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}
	public Calendar getDataDaVenda() {
		return dataDaVenda;
	}
	public void setDataDaVenda(Calendar dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
