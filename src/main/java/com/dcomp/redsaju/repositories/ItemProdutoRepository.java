package com.dcomp.redsaju.repositories;

import com.dcomp.redsaju.domain.ItemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Integer> {

}
