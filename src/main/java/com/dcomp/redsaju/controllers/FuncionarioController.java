package com.dcomp.redsaju.controllers;

import com.dcomp.redsaju.domain.Funcionario;
import com.dcomp.redsaju.domain.Produto;
import com.dcomp.redsaju.services.FuncionarioService;
import com.dcomp.redsaju.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public ModelAndView welcome() {
        List<Produto> produtos = produtoService.findAll();
        List<Funcionario> funcionarios = service.findAll();

        ModelAndView model = new ModelAndView("/funcionario/index.jsp");
        model.addObject("produtos", produtos);

        return model;
    }
}
