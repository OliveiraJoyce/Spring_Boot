package br.com.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.lojagames.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	 
	public List<Produto> findAllBynomeContainingIgnoreCase(String nome);
}
 