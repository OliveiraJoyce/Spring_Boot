package br.or.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;






@Entity 
@Table(name = "categoria")
public class Categoria {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@NotBlank
	private String departamento;
	
	@NotBlank
	private String categoria;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) 
	@JsonIgnoreProperties("categoria")
	private List<Produtos> produtos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	
}
