package com.cmc.alura.pruebas.test;

import java.util.List;

import javax.persistence.EntityManager;

import com.cmc.alura.pruebas.dao.CategoriaDao;
import com.cmc.alura.pruebas.dao.ProductoDao;
import com.cmc.alura.pruebas.modelo.Categoria;
import com.cmc.alura.pruebas.modelo.Producto;
import com.cmc.alura.pruebas.utils.JPAUtils;

public class RegistroProducto {

	public static void main(String[] args) {
		
		registrarProducto(); 
		EntityManager em = JPAUtils.getEntityManager(); 
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaProductoId(1l); 
		System.out.println(producto.getName());
		//double precio=productoDao.consultarPrecioPorNombreDeProducto("iPhone 15"); 
		//System.out.println(precio);
		
		//productos.forEach(prod->System.out.println(prod.getDescription()));
	}

	private static void registrarProducto () {
		Categoria categoria = new Categoria("Software"); 
		Producto celular = new Producto("Sistema de nomina de empleados","NOMINA ONE",25000, categoria);

		EntityManager em = JPAUtils.getEntityManager(); 
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em); 
		em.getTransaction().begin();
		productoDao.guardar(celular);
		categoriaDao.guardar(categoria);
		em.getTransaction().commit();
		em.close();
	}
}
