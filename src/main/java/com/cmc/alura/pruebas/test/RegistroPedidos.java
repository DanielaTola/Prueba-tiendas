package com.cmc.alura.pruebas.test;

import java.util.List;

import javax.persistence.EntityManager;

import com.cmc.alura.pruebas.dao.ClienteDao;
import com.cmc.alura.pruebas.dao.PedidoDao;
import com.cmc.alura.pruebas.dao.ProductoDao;
import com.cmc.alura.pruebas.modelo.Cliente;
import com.cmc.alura.pruebas.modelo.ItemsPedido;
import com.cmc.alura.pruebas.modelo.Pedido;
import com.cmc.alura.pruebas.modelo.Producto;
import com.cmc.alura.pruebas.utils.JPAUtils;
import com.cmc.alura.pruebas.vo.RelatorioDeVenta;

public class RegistroPedidos {

	public static void main(String[] args) {
		//registrPedido();
		EntityManager em = JPAUtils.getEntityManager(); 
		
		PedidoDao pedidoDao = new PedidoDao(em); 		
		
		double valorTotal = pedidoDao.valorTotalVendido(); 
		System.out.println("Valor total: "+valorTotal);
		double valorPromedio = pedidoDao.valorPromedioVendido();  
		System.out.println("Valor promedio: "+valorPromedio);
		List<Object[]> ventas = pedidoDao.relatorioDeVentas(); 
		for(Object[] obj: ventas) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}
		
		List<RelatorioDeVenta> ventasVO = pedidoDao.relatorioDeVentasVO(); 
		ventasVO.forEach(System.out::println);
	}
	
	public static void registrPedido() {
		EntityManager em = JPAUtils.getEntityManager();
		Cliente cliente = new Cliente("Daniela Tola", "0958911752"); 
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaProductoId(1l); 
		PedidoDao pedidoDao = new PedidoDao(em); 
		ClienteDao clienteDao = new ClienteDao(em); 
		Pedido pedido = new Pedido(cliente); 
		pedido.agregarItems(new ItemsPedido(5, producto, pedido));
		em.getTransaction().begin();
		clienteDao.guardar(cliente);
		pedidoDao.guardar(pedido);
		em.getTransaction().commit();
		
		em.close();
		
	}
}
