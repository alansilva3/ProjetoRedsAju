package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Compra;
import com.dcomp.redsaju.repositories.CompraRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repo;

    public Compra insert(Compra obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Compra find(Integer id) {
        Optional<Compra> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Compra.class.getName()));
    }

    public List<Compra> findAll() {
        return repo.findAll();
    }

    public Compra update(Compra obj) {
        find(obj.getId()); //Lança exceção caso o Compra não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Compra não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Compra");
        }
    }
}
