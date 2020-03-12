package com.dcomp.redsaju.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PagamentoController {
	
	@RequestMapping(value = "/checkout")
    public ModelAndView home(HttpSession session) {   	    	

        ModelAndView model = new ModelAndView("/checkout.jsp");

        model.addObject("carrinho", session.getAttribute("carrinho"));        

        return model;
    }
}
