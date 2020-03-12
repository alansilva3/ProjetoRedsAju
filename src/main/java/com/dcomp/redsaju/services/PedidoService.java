package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Pedido;
import com.dcomp.redsaju.repositories.PedidoRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    public List<Pedido> findAll() {
        return repo.findAll();
    }

    public Pedido update(Pedido obj) {
        find(obj.getId()); //Lança exceção caso o Pedido não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o Pedido não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o Pedido");
        }
    }
}
