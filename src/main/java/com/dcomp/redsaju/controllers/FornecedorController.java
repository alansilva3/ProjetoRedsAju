package com.dcomp.redsaju.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dcomp.redsaju.domain.Fornecedor;
import com.dcomp.redsaju.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/")
    public ModelAndView welcome() {
        List<Fornecedor> fornecedores = fornecedorService.findAll();

        ModelAndView model = new ModelAndView("/fornecedores/index.jsp");
        model.addObject("fornecedores", fornecedores);

        return model;
    }
}
