package com.dcomp.redsaju.repositories;

import com.dcomp.redsaju.domain.Fornecimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecimentoRepository extends JpaRepository<Fornecimento, Integer> {

}
