package br.com.generation.atividade1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/atividade1")
public class Atividade1 {

	@GetMapping
	public String atividade1() {
		return " A mentalidade usada foi persistência e a habilidade atenção aos detalhes";
	}
	
}
