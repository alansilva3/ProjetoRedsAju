package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.Fornecimento;

@Repository
public interface FornecimentoRepository extends JpaRepository<Fornecimento, Integer>{

}
