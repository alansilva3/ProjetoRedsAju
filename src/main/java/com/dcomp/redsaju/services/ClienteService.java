package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Cliente;
import com.dcomp.redsaju.repositories.ClienteRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente insert(Cliente obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Cliente update(Cliente obj) {
        find(obj.getId()); //Lança exceção caso o Cliente não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Cliente não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Cliente");
        }
    }
}
