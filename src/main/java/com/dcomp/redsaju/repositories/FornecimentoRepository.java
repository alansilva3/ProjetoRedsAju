package com.dcomp.redsaju.repositories;

import com.dcomp.redsaju.domain.Fornecedor;
import com.dcomp.redsaju.domain.Fornecimento;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface FornecimentoRepository extends JpaRepository<Fornecimento, Integer> {
     
     List<Fornecimento> findByFornecedor(Fornecedor fornecedor);
}
