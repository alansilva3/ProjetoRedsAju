package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Fornecimento;
import com.dcomp.redsaju.repositories.FornecimentoRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecimentoService {

    @Autowired
    private FornecimentoRepository repo;

    public Fornecimento insert(Fornecimento obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Fornecimento find(Integer id) {
        Optional<Fornecimento> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecimento.class.getName()));
    }

    public List<Fornecimento> findAll() {
        return repo.findAll();
    }

    public Fornecimento update(Fornecimento obj) {
        find(obj.getId()); //Lança exceção caso o Fornecimento não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Fornecimento não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Fornecimento");
        }
    }
}
