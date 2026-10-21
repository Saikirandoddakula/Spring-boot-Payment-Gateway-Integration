package com.springboot.saikiran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.saikiran.dto.PaymentRequest;
import com.springboot.saikiran.service.PaymentService;

@RestController
public class PaymentController 
{
	@Autowired
	PaymentService paymentService;
	
	@PostMapping(value="/get/details")
	public String getDetails(@RequestBody PaymentRequest paymentRequest)
	{
		
		return paymentService.intiateRequest(paymentRequest);
	}
	

}
