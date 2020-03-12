package com.dcomp.redsaju.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dcomp.redsaju.domain.Carrinho;
import com.dcomp.redsaju.domain.ItemProduto;
import com.dcomp.redsaju.domain.Produto;
import com.dcomp.redsaju.services.ProdutoService;

@Controller
public class HomeController {
	
	@Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/")
    public ModelAndView home(HttpSession session) {
    	
    	if (session.getAttribute("cart") == null) {
    		Carrinho carrinho = new Carrinho();
    		session.setAttribute("carrinho", carrinho);
    	}
    	
    	
    	List<Produto> produtos = produtoService.findAll();

        ModelAndView model = new ModelAndView("index.jsp");
        model.addObject("produtos", produtos);
        model.addObject("carrinho", session.getAttribute("carrinho"));

        return model;
    }
    
    @RequestMapping(value = "/{id}")
    public ModelAndView addCart(@PathVariable Integer id, HttpSession session) {    	
    	
    	Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
    		
    	List<ItemProduto> produtosCarrinho = carrinho.getItens();
    	
    	Produto produto = produtoService.find(id);
    	
    	ItemProduto item = new ItemProduto();
    	item.setProduto(produto);
    	item.setQuantidade(1);    	
    	
    	carrinho.setItem(item); 	
    	
    	session.setAttribute("carrinho", carrinho);
    	
    	List<Produto> produtos = produtoService.findAll();

        ModelAndView model = new ModelAndView("index.jsp");
        model.addObject("produtos", produtos);
        model.addObject("carrinho", session.getAttribute("carrinho"));

        return model;
    }
}
