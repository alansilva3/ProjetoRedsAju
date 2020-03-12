package com.dcomp.redsaju.controllers;

import com.dcomp.redsaju.domain.Produto;
import com.dcomp.redsaju.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/{id}")
    public Produto finById(@PathVariable Integer id) {
        return service.find(id);
    }
}
