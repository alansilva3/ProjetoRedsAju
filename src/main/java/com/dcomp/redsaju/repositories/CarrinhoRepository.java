package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer>{

}
