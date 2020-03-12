package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Endereco;
import com.dcomp.redsaju.repositories.EnderecoRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repo;

    public Endereco insert(Endereco obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Endereco find(Integer id) {
        Optional<Endereco> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
    }

    public List<Endereco> findAll() {
        return repo.findAll();
    }

    public Endereco update(Endereco obj) {
        find(obj.getId()); //Lança exceção caso o Endereco não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Endereco não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Endereco");
        }
    }
}
