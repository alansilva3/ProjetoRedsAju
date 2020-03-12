package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.NotaFiscalCompra;
import com.dcomp.redsaju.repositories.NotaFiscalCompraRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalCompraService {

    @Autowired
    private NotaFiscalCompraRepository repo;

    public NotaFiscalCompra insert(NotaFiscalCompra obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public NotaFiscalCompra find(Integer id) {
        Optional<NotaFiscalCompra> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + NotaFiscalCompra.class.getName()));
    }

    public List<NotaFiscalCompra> findAll() {
        return repo.findAll();
    }

    public NotaFiscalCompra update(NotaFiscalCompra obj) {
        find(obj.getId()); //Lança exceção caso o NotaFiscalCompra não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o NotaFiscalCompra não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o NotaFiscalCompra");
        }
    }
}
