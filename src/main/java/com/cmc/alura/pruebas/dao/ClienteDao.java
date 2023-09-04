package com.cmc.alura.pruebas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cmc.alura.pruebas.modelo.Cliente;
import com.cmc.alura.pruebas.modelo.Pedido;

public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}

	public void guardar(Cliente cliente) {

		this.em.persist(cliente);
	}


	public Cliente consultaProductoId(Long id) {
		return em.find(Cliente.class, id); 
	}
	
	public List<Cliente> consultarTodos(){
		String jpql = "SELECT P FROM Cliente AS P";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
}
