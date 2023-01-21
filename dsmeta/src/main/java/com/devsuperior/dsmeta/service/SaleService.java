package com.devsuperior.dsmeta.service;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepo;
	
	public Page<Sale> findSales(LocalDate minDate, LocalDate maxDate, Pageable pageable) {
		minDate = Objects.isNull(minDate) ? LocalDate.now().minusDays(365) : minDate;
		maxDate = Objects.isNull(maxDate) ? LocalDate.now() : maxDate;
		
		return saleRepo.findAllByDateBetween(minDate, maxDate, pageable);
	}
	
}
