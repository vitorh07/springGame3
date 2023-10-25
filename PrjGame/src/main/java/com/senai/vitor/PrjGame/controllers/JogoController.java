package com.senai.vitor.PrjGame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.vitor.PrjGame.entities.Jogo;
import com.senai.vitor.PrjGame.services.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	private final JogoService jogoService;
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // Nome do seu arquivo HTML (sem a extensão)
	}
	
	@Autowired
	public JogoController (JogoService jogoService) {
		this.jogoService = jogoService;
	}
	
	@PostMapping
	public Jogo createProduct(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);
	}

	@GetMapping
	public List<Jogo> getAllProdutos(){
		return jogoService.getAllJogo();
	}
	
	@GetMapping("/{id}")
	public Jogo getJogo(@PathVariable Long id) {
		return jogoService.getJogoById(id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		jogoService.deleteProduto(id);
	}
	
		
		@PutMapping("/{id}")
		public Jogo updateJogo(@PathVariable Long id, @RequestBody Jogo jogo) {
		    return jogoService.updateJogo(id, jogo);
		}
	
}

