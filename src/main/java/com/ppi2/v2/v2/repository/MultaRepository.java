package com.ppi2.v2.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppi2.v2.v2.domain.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long> {

}
