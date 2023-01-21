package com.devsuperior.dsmeta.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SaleService;
import com.devsuperior.dsmeta.service.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate minDate,
			@RequestParam(value = "maxDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate maxDate,
			Pageable pageable){
		return saleService.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) throws Exception {
		smsService.sendSms(id);
	}
	
}
