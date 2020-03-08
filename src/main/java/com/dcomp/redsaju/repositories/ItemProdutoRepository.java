package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.ItemProduto;

@Repository
public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Integer>{

}
