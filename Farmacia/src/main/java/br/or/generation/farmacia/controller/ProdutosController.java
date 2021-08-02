package br.or.generation.farmacia.controller;

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

import br.or.generation.farmacia.model.Produtos;
import br.or.generation.farmacia.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@GetMapping	
	private ResponseEntity<List<Produtos>> getAll(){
		
		return ResponseEntity.ok(produtosRepository.findAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Produtos> GetById(@PathVariable long id){ 
		return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build()); 
	}
	@GetMapping ("/nome/{nome}")  
	public ResponseEntity<List<Produtos>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome)); 
		
	}
	@GetMapping ("/marca/{marca}")  
	public ResponseEntity<List<Produtos>> GetByMarca(@PathVariable String marca){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(marca)); 
		
	}
	@GetMapping ("/preco/{preco}")  
	public ResponseEntity<List<Produtos>> GetByPreco(@PathVariable String preco){
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(preco)); 
		
	}
	@PostMapping 
	public ResponseEntity<Produtos> post (@RequestBody Produtos produtos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
	}
	
	
	@PutMapping
	public ResponseEntity<Produtos> put (@RequestBody Produtos produtos) {
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		produtosRepository.deleteById(id); 
	}
}
