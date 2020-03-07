package com.dcomp.redsaju;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dcomp.redsaju.domain.Produto;
import com.dcomp.redsaju.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoRedsAjuApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoRedsAjuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Produto prod1 = new Produto(null, "Camisa1", "url-da-imagem-aqui", 150.0, 80.0, "imagine uma descrição aqui");
		Produto prod2 = new Produto(null, "Camisa2", "url-da-imagem-aqui", 120.0, 40.0, "imagine uma descrição aqui");
		Produto prod3 = new Produto(null, "Camisa3", "url-da-imagem-aqui", 180.0, 100.0, "imagine uma descrição aqui");
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
	}

}
