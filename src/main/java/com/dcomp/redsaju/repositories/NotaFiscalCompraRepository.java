package com.dcomp.redsaju.repositories;

import com.dcomp.redsaju.domain.NotaFiscalCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalCompraRepository extends JpaRepository<NotaFiscalCompra, Integer> {

}
