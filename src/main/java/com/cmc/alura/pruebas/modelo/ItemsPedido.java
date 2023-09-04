package com.cmc.alura.pruebas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items_pedido")
public class ItemsPedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private int cantidad; 
	private double precioUnitario; 
	@ManyToOne
	private Producto producto; 
	@ManyToOne
	private Pedido pedido;
	
	public ItemsPedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemsPedido(int cantidad,  Producto producto, Pedido pedido) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.pedido = pedido;
		this.precioUnitario = producto.getPrecio(); 
	}
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public double getValor() {
		return this.precioUnitario*this.cantidad; 
	}
	
	
	
}
