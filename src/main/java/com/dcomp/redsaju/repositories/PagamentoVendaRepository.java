package com.dcomp.redsaju.repositories;

import com.dcomp.redsaju.domain.PagamentoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoVendaRepository extends JpaRepository<PagamentoVenda, Integer> {

}
