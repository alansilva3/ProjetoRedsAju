package com.dcomp.redsaju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcomp.redsaju.domain.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
