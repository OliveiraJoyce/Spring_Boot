package br.or.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import br.or.generation.farmacia.model.Produtos;


public interface ProdutosRepository extends JpaRepository<Produtos, Long>{
	public List<Produtos> findAllByNomeContainingIgnoreCase (String Nome);
	public List<Produtos> findAllByMarcaContainingIgnoreCase(String marca);
	
}
