package com.ppi2.v2.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ppi2.v2.v2.domain.Avaria;

@Repository
public interface AvariaRepository extends JpaRepository<Avaria, Long> {

}
