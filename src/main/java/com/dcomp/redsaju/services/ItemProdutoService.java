package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.ItemProduto;
import com.dcomp.redsaju.repositories.ItemProdutoRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemProdutoService {

    @Autowired
    private ItemProdutoRepository repo;

    public ItemProduto insert(ItemProduto obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public ItemProduto find(Integer id) {
        Optional<ItemProduto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + ItemProduto.class.getName()));
    }

    public List<ItemProduto> findAll() {
        return repo.findAll();
    }

    public ItemProduto update(ItemProduto obj) {
        find(obj.getId()); //Lança exceção caso o ItemProduto não exista

        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id); //Lança exceção caso o ItemProduto não exista

        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o ItemProduto");
        }
    }
}
