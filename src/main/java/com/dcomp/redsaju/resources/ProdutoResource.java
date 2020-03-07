package com.dcomp.redsaju.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcomp.redsaju.domain.Produto;

@RestController
@RequestMapping (value = "/produtos")
public class ProdutoResource {

	@GetMapping
	public List<Produto> listar() {
		
		Produto prod1 = new Produto(1, "Camisa1","urlaqui",150.0, 80.0, "Camisa de um time random");
		Produto prod2 = new Produto(2, "Camisa2","urlaqui",180.0, 100.0, "Camisa de um time random2");
		
		List<Produto> lista = new ArrayList<>();
		lista.add(prod1);
		lista.add(prod2);
		
		return lista;
	}
}
