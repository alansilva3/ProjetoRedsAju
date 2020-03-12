package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Carrinho;
import com.dcomp.redsaju.repositories.CarrinhoRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repo;

    public Carrinho insert(Carrinho obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Carrinho find(Integer id) {
        Optional<Carrinho> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Carrinho.class.getName()));
    }

    public List<Carrinho> findAll() {
        return repo.findAll();
    }

    public Carrinho update(Carrinho obj) {
        find(obj.getId()); //Lança exceção caso o Carrinho não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Carrinho não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Carrinho");
        }
    }
}
