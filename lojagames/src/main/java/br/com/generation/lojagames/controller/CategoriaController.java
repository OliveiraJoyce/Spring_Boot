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

import br.com.generation.lojagames.model.Categoria;
import br.com.generation.lojagames.repository.CategoriaRepository;


@RestController
@RequestMapping("/categorias") //endpoint-URL
@CrossOrigin(origins="*", allowedHeaders="*")
public class CategoriaController {

	//INJEÇÃO DE DEPENDENCIA - Transferir a responsabilidade para Spring 
	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	private ResponseEntity<List<Categoria>> getAll(){
		
		return ResponseEntity.ok(categoriaRepository.findAll());
		
	}
	

	@GetMapping("/{id}") //{} Variavel
	private ResponseEntity<Categoria> getById(@PathVariable long id){
		
		return categoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> GetByTipo(@PathVariable String tipo){
		
		return ResponseEntity.ok(categoriaRepository.findAllByTipoContainingIgnoreCase(tipo));	
	}
	
	// esse metodo insere postagens no banco de dados. 
		@PostMapping 
		public ResponseEntity<Categoria> post (@RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
		}
		
		// esse metodo faz alterações nas postagens. 
		@PutMapping
		public ResponseEntity<Categoria> put (@RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
		}
		
		// deleta 
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			categoriaRepository.deleteById(id); 
		}
}
