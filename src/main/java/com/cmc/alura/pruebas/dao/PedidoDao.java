package com.cmc.alura.pruebas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cmc.alura.pruebas.modelo.Pedido;
import com.cmc.alura.pruebas.vo.RelatorioDeVenta;

public class PedidoDao {

	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void guardar(Pedido pedido) {

		this.em.persist(pedido);
	}

	public Pedido consultaProductoId(Long id) {
		return em.find(Pedido.class, id);
	}

	public List<Pedido> consultarTodos() {
		String jpql = "SELECT P FROM Pedido AS P";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}

	public double valorTotalVendido() {
		String jpql = "SELECT SUM (P.valorTotal) FROM Pedido P";
		return em.createQuery(jpql, Double.class).getSingleResult();
	}

	public double valorPromedioVendido() {
		String jpql = "SELECT AVG (P.valorTotal) FROM Pedido P";
		return em.createQuery(jpql, Double.class).getSingleResult();
	}

	public List<Object[]> relatorioDeVentas() {
		String jpql = "SELECT producto.name, "
				+ "SUM (item.cantidad), "
				+ "MAX(pedido.date) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.name "
				+ "ORDER BY item.cantidad DESC";
		return em.createQuery(jpql, Object[].class).getResultList();
	}
	
	public List<RelatorioDeVenta> relatorioDeVentasVO() {
		String jpql = "SELECT new com.cmc.alura.pruebas.vo.RelatorioDeVenta(producto.name, "
				+ "SUM (item.cantidad), "
				+ "MAX(pedido.date))"
				+ "FROM Pedido pedido "
				+ "JOIN pedido.items item "
				+ "JOIN item.producto producto "
				+ "GROUP BY producto.name "
				+ "ORDER BY item.cantidad DESC";
		return em.createQuery(jpql, RelatorioDeVenta.class).getResultList();
	}

}
