package com.dcomp.redsaju.repositories;

import com.dcomp.redsaju.domain.PagamentoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoCompraRepository extends JpaRepository<PagamentoCompra, Integer> {

}
