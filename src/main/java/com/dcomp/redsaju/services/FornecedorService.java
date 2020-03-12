package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Fornecedor;
import com.dcomp.redsaju.repositories.FornecedorRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repo;

    public Fornecedor insert(Fornecedor obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Fornecedor find(Integer id) {
        Optional<Fornecedor> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecedor.class.getName()));
    }

    public List<Fornecedor> findAll() {
        return repo.findAll();
    }

    public Fornecedor update(Fornecedor obj) {
        find(obj.getId()); //Lança exceção caso o Fornecedor não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Fornecedor não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Fornecedor");
        }
    }
}
