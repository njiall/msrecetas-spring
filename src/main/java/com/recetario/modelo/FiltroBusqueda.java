package com.recetario.modelo;

import java.util.Date;

public class FiltroBusqueda {

	private String nombre;
	private String categoria;
	private String etiquetas;
	private String ingredientes;
	private Date fechaDesde;
	private Date fechaHasta;
	
	
	
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}



	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	/**
	 * @return the etiquetas
	 */
	public String getEtiquetas() {
		return etiquetas;
	}



	/**
	 * @param etiquetas the etiquetas to set
	 */
	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}



	/**
	 * @return the ingredientes
	 */
	public String getIngredientes() {
		return ingredientes;
	}



	/**
	 * @param ingredientes the ingredientes to set
	 */
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}



	/**
	 * @return the fechaDesde
	 */
	public Date getFechaDesde() {
		return fechaDesde;
	}



	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}



	/**
	 * @return the fechaHasta
	 */
	public Date getFechaHasta() {
		return fechaHasta;
	}



	/**
	 * @param fechaHasta the fechaHasta to set
	 */
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public FiltroBusqueda(String nombre, String categoria, String etiquetas, String ingredientes, Date fechaDesde, Date fechaHasta) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.etiquetas = etiquetas;
		this.ingredientes = ingredientes;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}



	public FiltroBusqueda() {
		super();
	}
	
	

}
