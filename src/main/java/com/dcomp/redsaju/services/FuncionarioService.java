package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Funcionario;
import com.dcomp.redsaju.repositories.FuncionarioRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    public Funcionario insert(Funcionario obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Funcionario find(Integer id) {
        Optional<Funcionario> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
    }

    public List<Funcionario> findAll() {
        return repo.findAll();
    }

    public Funcionario update(Funcionario obj) {
        find(obj.getId()); //Lança exceção caso o Funcionario não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Funcionario não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Funcionario");
        }
    }
}
