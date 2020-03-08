package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.PagamentoCompra;

@Repository
public interface PagamentoCompraRepository extends JpaRepository<PagamentoCompra, Integer>{

}
