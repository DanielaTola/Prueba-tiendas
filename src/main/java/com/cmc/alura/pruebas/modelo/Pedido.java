package com.cmc.alura.pruebas.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private LocalDate date; 
	private double valorTotal;
	@ManyToOne
	private Cliente cliete;
	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
	private List<ItemsPedido> items; 
	
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedido(Cliente cliete) {
		super();
		this.date = LocalDate.now();
		this.cliete = cliete;
		this.items = new ArrayList<ItemsPedido>(); 
	}
	
	public void agregarItems(ItemsPedido item) {
		//accede al pedido de esta clase 
		item.setPedido(this);
		this.items.add(item); 
		this.valorTotal = this.valorTotal+item.getValor(); 
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Cliente getCliete() {
		return cliete;
	}
	public void setCliete(Cliente cliete) {
		this.cliete = cliete;
	} 
	
	

}
