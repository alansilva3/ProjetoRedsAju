package com.dcomp.redsaju.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dcomp.redsaju.domain.Carrinho;
import com.dcomp.redsaju.domain.ItemProduto;
import com.dcomp.redsaju.domain.Produto;
import com.dcomp.redsaju.services.ProdutoService;

@Controller
public class CartController {
	
	@Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "/cart")
    public ModelAndView home(HttpSession session) {   	    	

        ModelAndView model = new ModelAndView("/cart/index.jsp");

        model.addObject("carrinho", session.getAttribute("carrinho"));        

        return model;
    }

}
