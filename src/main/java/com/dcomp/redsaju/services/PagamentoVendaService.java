package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.PagamentoVenda;
import com.dcomp.redsaju.repositories.PagamentoVendaRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoVendaService {

    @Autowired
    private PagamentoVendaRepository repo;

    public PagamentoVenda insert(PagamentoVenda obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public PagamentoVenda find(Integer id) {
        Optional<PagamentoVenda> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + PagamentoVenda.class.getName()));
    }

    public List<PagamentoVenda> findAll() {
        return repo.findAll();
    }

    public PagamentoVenda update(PagamentoVenda obj) {
        find(obj.getId()); //Lança exceção caso o PagamentoVenda não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o PagamentoVenda não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o PagamentoVenda");
        }
    }
}
