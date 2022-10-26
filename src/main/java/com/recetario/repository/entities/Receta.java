package com.recetario.repository.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="recetas")
public class Receta extends EntidadAbstracta{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto Inc en MariaDB
	private Long id;
	
	private String nombre;
	
	//@ManyToOne
	//private Categoria categoria;
	
	private String categoria;
	
	@Column(length = 300)
	private String etiquetas;
	
	@Column(length = 4000)
	private String ingredientes;
	
	@Column(length = 4000)
	private String instrucciones;
	
	@Column(length = 4000)
	private String notas;
	
	

	public Receta() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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
//	 * @return the ingredientes
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
	 * @return the instrucciones
	 */
	public String getInstrucciones() {
		return instrucciones;
	}

	/**
	 * @param instrucciones the instrucciones to set
	 */
	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}

	/**
	 * @return the notas
	 */
	public String getNotas() {
		return notas;
	}

	/**
	 * @param notas the notas to set
	 */
	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(String etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	

}
