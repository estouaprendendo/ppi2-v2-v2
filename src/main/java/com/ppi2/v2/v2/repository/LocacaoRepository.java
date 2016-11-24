package com.ppi2.v2.v2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ppi2.v2.v2.domain.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

	@Query(value = "select * from locacao where MONTH(locacao.data) = ?1", nativeQuery = true)
	List<Locacao> findMes(Long nmes);

}
