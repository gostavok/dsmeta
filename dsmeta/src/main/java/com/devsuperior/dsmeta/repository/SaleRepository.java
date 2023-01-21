package com.devsuperior.dsmeta.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsmeta.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

	Page<Sale> findAllByDateBetween(LocalDate inicio, LocalDate fim, Pageable pageable);

}
