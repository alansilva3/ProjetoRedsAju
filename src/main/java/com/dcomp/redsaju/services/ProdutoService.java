package com.dcomp.redsaju.services;

import com.dcomp.redsaju.domain.Produto;
import com.dcomp.redsaju.repositories.ProdutoRepository;
import com.dcomp.redsaju.services.exceptions.DataIntegrityException;
import com.dcomp.redsaju.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    public List<Produto> findAll() {
        return repo.findAll();
    }

    //Busca todos os produtos usando paginação <findPage(0, 24, "nome", "ASC")>
    public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Produto find(Integer id) {
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Produto insert(Produto obj) {
        obj.setCodigo(null);
        return repo.save(obj);
    }

    public Produto update(Produto obj) {
        find(obj.getCodigo()); //Lança exceção caso o produto não exista
        return repo.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir o produto");
        }
    }
}
