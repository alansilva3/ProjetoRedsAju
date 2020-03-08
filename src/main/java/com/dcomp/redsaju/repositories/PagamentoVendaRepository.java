package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.PagamentoVenda;

@Repository
public interface PagamentoVendaRepository extends JpaRepository<PagamentoVenda, Integer>{

}
