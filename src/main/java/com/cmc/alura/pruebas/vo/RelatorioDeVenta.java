package com.cmc.alura.pruebas.vo;

import java.time.LocalDate;

public class RelatorioDeVenta {
	private String nombreDelProducto;
	private int cantidadDeProducto;
	private LocalDate fechaDeUltimaVenta;

	public RelatorioDeVenta() {
	}

	public RelatorioDeVenta(String nombreDelProducto, int cantidadDeProducto, LocalDate fechaDeUltimaVenta) {
		
		this.nombreDelProducto = nombreDelProducto;
		this.cantidadDeProducto = cantidadDeProducto;
		this.fechaDeUltimaVenta = fechaDeUltimaVenta;
	}

	public String getNombreDelProducto() {
		return nombreDelProducto;
	}

	public void setNombreDelProducto(String nombreDelProducto) {
		this.nombreDelProducto = nombreDelProducto;
	}

	public int getCantidadDeProducto() {
		return cantidadDeProducto;
	}

	public void setCantidadDeProducto(int cantidadDeProducto) {
		this.cantidadDeProducto = cantidadDeProducto;
	}

	public LocalDate getFechaDeUltimaVenta() {
		return fechaDeUltimaVenta;
	}

	public void setFechaDeUltimaVenta(LocalDate fechaDeUltimaVenta) {
		this.fechaDeUltimaVenta = fechaDeUltimaVenta;
	}

	@Override
	public String toString() {
		return "RelatorioDeVenta \nnombreDelPRoducto: " + nombreDelProducto + "\ncantidadDeProducto: " + cantidadDeProducto
				+ "\nfechaDeUltimaVenta: " + fechaDeUltimaVenta;
	}

	
}
