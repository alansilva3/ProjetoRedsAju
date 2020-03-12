package com.dcomp.redsaju.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dcomp.redsaju.domain.Produto;
import com.dcomp.redsaju.services.ProdutoService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public ModelAndView welcome() {
        List<Produto> produtos = produtoService.findAll();

        ModelAndView model = new ModelAndView("/funcionario/index.jsp");
        model.addObject("produtos", produtos);

        return model;
    }
}
