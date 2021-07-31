package br.com.generation.lojagames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.lojagames.model.Produto;
import br.com.generation.lojagames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins="*", allowedHeaders="*")
public class ProdutoController {

	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	private ResponseEntity<List<Produto>> getAll(){
		
		return ResponseEntity.ok(produtoRepository.findAll());
	}	

	@GetMapping("/{id}") //{} Variavel
	private ResponseEntity<Produto> getById(@PathVariable long id){
				return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	private ResponseEntity<List<Produto>> GetByNome(@PathVariable String nome){
		
		return ResponseEntity.ok(produtoRepository.findAllBynomeContainingIgnoreCase(nome));	
	}
	
	@GetMapping("/descricao/{descricao}")
	private ResponseEntity<List<Produto>> GetByDescricao(@PathVariable String descricao){
		
		return ResponseEntity.ok(produtoRepository.findAllBynomeContainingIgnoreCase(descricao));	
	}
	
	@GetMapping("/preco/{preco}")
	private ResponseEntity<List<Produto>> GetByPreco(@PathVariable String preco){
		
		return ResponseEntity.ok(produtoRepository.findAllBynomeContainingIgnoreCase(preco));	
	}
	@PostMapping 
	public ResponseEntity<Produto> post (@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	// esse metodo faz alterações nas postagens. 
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}
	
	// deleta 
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		produtoRepository.deleteById(id); 
	}
	
}
