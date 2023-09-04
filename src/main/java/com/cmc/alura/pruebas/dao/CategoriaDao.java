package com.cmc.alura.pruebas.dao;

import javax.persistence.EntityManager;

import com.cmc.alura.pruebas.modelo.Categoria;



public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}

	public void guardar(Categoria categoria) {

		this.em.persist(categoria);
	}
}
