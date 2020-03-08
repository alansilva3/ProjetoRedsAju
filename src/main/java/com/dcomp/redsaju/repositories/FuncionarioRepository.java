package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

}
