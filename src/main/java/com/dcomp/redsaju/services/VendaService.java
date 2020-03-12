package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Venda;
import com.dcomp.redsaju.repositories.VendaRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repo;

    public Venda insert(Venda obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Venda find(Integer id) {
        Optional<Venda> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Venda.class.getName()));
    }

    public List<Venda> findAll() {
        return repo.findAll();
    }

    public Venda update(Venda obj) {
        find(obj.getId()); //Lança exceção caso o Venda não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Venda não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Venda");
        }
    }
}
