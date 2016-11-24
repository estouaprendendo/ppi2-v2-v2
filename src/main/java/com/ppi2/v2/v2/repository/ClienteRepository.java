package com.ppi2.v2.v2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ppi2.v2.v2.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(value = "select * from cliente where id_cliente = (select id_cliente from (select id_cliente , count(*) maximo from locacao where MONTH(data) = ?1 group by id_cliente order by maximo desc) as cliente limit 1)", nativeQuery = true)
	List<Cliente> findClienteMaxLocationMonth(Long nmes);

	@Query(value = "select * from cliente where cpf = ?1", nativeQuery = true)
	Cliente findByCpf(String cpf);

}
