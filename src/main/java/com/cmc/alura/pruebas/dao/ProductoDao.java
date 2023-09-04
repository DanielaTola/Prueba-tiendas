package com.cmc.alura.pruebas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cmc.alura.pruebas.modelo.Producto;

public class ProductoDao {

	private EntityManager em;

	public ProductoDao(EntityManager em) {
		this.em=em;
	}

	public void guardar(Producto producto) {

		this.em.persist(producto);
	}

	public Producto consultaProductoId(Long id) {
		return em.find(Producto.class, id); 
	}
	
	public List<Producto> consultarTodos(){
		String jpql = "SELECT P FROM Producto AS P";
		return em.createQuery(jpql, Producto.class).getResultList();
	}
	
	public List<Producto> consultarPorNombre(String name){
		String jpql = "SELECT P FROM Producto AS P WHERE P.name=:name";
		return em.createQuery(jpql).setParameter("name",name).getResultList(); 
	}
	
	public List<Producto> consultarPorNombreDeCategoria(String name){
		String jpql = "SELECT P FROM Producto AS P WHERE P.categoria.name=:name";
		return em.createQuery(jpql).setParameter("name",name).getResultList(); 
	}
	
	public double consultarPrecioPorNombreDeProducto(String name) {
		String jpql = "SELECT P.precio FROM Producto AS P WHERE P.name=:name";
		return em.createQuery(jpql,Double.class).setParameter("name",name).getSingleResult();
	}
}
