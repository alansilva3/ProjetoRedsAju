package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.NotaFiscalVenda;
import com.dcomp.redsaju.repositories.NotaFiscalVendaRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalVendaService {

    @Autowired
    private NotaFiscalVendaRepository repo;

    public NotaFiscalVenda insert(NotaFiscalVenda obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public NotaFiscalVenda find(Integer id) {
        Optional<NotaFiscalVenda> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + NotaFiscalVenda.class.getName()));
    }

    public List<NotaFiscalVenda> findAll() {
        return repo.findAll();
    }

    public NotaFiscalVenda update(NotaFiscalVenda obj) {
        find(obj.getId()); //Lança exceção caso o NotaFiscalVenda não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o NotaFiscalVenda não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o NotaFiscalVenda");
        }
    }
}
