package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

}
