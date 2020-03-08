package com.dcomp.redsaju;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dcomp.redsaju.domain.Carrinho;
import com.dcomp.redsaju.domain.Cliente;
import com.dcomp.redsaju.domain.Endereco;
import com.dcomp.redsaju.domain.Fornecedor;
import com.dcomp.redsaju.domain.ItemProduto;
import com.dcomp.redsaju.domain.Produto;
import com.dcomp.redsaju.repositories.CarrinhoRepository;
import com.dcomp.redsaju.repositories.ClienteRepository;
import com.dcomp.redsaju.repositories.EnderecoRepository;
import com.dcomp.redsaju.repositories.FornecedorRepository;
import com.dcomp.redsaju.repositories.ItemProdutoRepository;
import com.dcomp.redsaju.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoRedsAjuApplication implements CommandLineRunner {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ItemProdutoRepository itemProdutoRepository;
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoRedsAjuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Endereco ender1 = new Endereco(null, "logradouro1", "bairro1", "cidade1", "estado1", "complemento1", "cep1");
		Endereco ender2 = new Endereco(null, "logradouro2", "bairro2", "cidade2", "estado2", "complemento2", "cep2");
		Endereco ender3 = new Endereco(null, "logradouro3", "bairro3", "cidade3", "estado3", "complemento3", "cep3");
		enderecoRepository.saveAll(Arrays.asList(ender1, ender2, ender3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente cli1 = new Cliente(null, "cliente1", "633.771.490-31", "cliente1@gmail.com", sdf.parse("01/01/2000") , "34927349283", ender1);
		
		Produto prod1 = new Produto(null, "Camisa1", "url-da-imagem-aqui", 150.0, 80.0, "imagine uma descrição aqui");
		Produto prod2 = new Produto(null, "Camisa2", "url-da-imagem-aqui", 120.0, 40.0, "imagine uma descrição aqui");
		Produto prod3 = new Produto(null, "Camisa3", "url-da-imagem-aqui", 180.0, 100.0, "imagine uma descrição aqui");
		
		Fornecedor forn1 = new Fornecedor(null, "Fornecedor1", "71.414.983/0001-50", "forn1@gmail.com", ender3);
		Fornecedor forn2 = new Fornecedor(null, "Fornecedor2", "64.325.527/0001-79", "forn2@gmail.com", ender2);
		
		prod1.setFornecedor(forn1);
		prod1.setFornecedor(forn2);
		prod2.setFornecedor(forn1);
		prod3.setFornecedor(forn2);
		fornecedorRepository.saveAll(Arrays.asList(forn1, forn2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		ItemProduto item1 = new ItemProduto(null, 10, prod1);
		ItemProduto item2 = new ItemProduto(null, 15, prod2);
		ItemProduto item3 = new ItemProduto(null, 8, prod3);
		itemProdutoRepository.saveAll(Arrays.asList(item1, item2, item3));
		
		Carrinho carr1 = new Carrinho(null, cli1);
		carr1.setItem(item1);
		carr1.setItem(item2);
		cli1.setCarrinho(carr1);
		clienteRepository.saveAll(Arrays.asList(cli1));
		carrinhoRepository.save(carr1);
	}
}
