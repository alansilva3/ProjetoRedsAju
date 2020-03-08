package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.NotaFiscalCompra;

@Repository
public interface NotaFiscalCompraRepository extends JpaRepository<NotaFiscalCompra, Integer>{

}
