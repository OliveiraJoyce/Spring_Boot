package br.com.generation.atividade1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividade2")
public class Atividade2 {
	
	@GetMapping
	public String atividade2 () {
		return "Meus objetivos é continuar persistindo mesmo diante das dificuldades e organizar minha gestão de tempo";
	}
}
