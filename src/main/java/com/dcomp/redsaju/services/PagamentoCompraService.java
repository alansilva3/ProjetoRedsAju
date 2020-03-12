package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.PagamentoCompra;
import com.dcomp.redsaju.repositories.PagamentoCompraRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoCompraService {

    @Autowired
    private PagamentoCompraRepository repo;

    public PagamentoCompra insert(PagamentoCompra obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public PagamentoCompra find(Integer id) {
        Optional<PagamentoCompra> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + PagamentoCompra.class.getName()));
    }

    public List<PagamentoCompra> findAll() {
        return repo.findAll();
    }

    public PagamentoCompra update(PagamentoCompra obj) {
        find(obj.getId()); //Lança exceção caso o PagamentoCompra não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o PagamentoCompra não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o PagamentoCompra");
        }
    }
}
