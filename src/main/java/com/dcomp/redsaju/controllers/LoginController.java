package com.dcomp.redsaju.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dcomp.redsaju.services.ClienteService;
import com.dcomp.redsaju.services.FuncionarioService;
import com.dcomp.redsaju.services.ProdutoService;

@Controller
public class LoginController {
	@Autowired
    private ProdutoService produtoService;
	
	@Autowired
    private ClienteService clienteService;
	
	@Autowired
    private FuncionarioService funcionarioService;

    @RequestMapping(value = "/login/")
    public ModelAndView home(HttpSession session) {   	    	

        ModelAndView model = new ModelAndView("login.jsp");

        model.addObject("carrinho", session.getAttribute("carrinho"));        

        return model;
    }
}
