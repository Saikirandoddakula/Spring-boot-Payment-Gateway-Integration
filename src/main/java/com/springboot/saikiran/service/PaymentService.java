package com.springboot.saikiran.service;

import com.springboot.saikiran.dto.PaymentRequest;
import com.springboot.saikiran.repository.PaymentRepository;

public interface PaymentService {

	
	
	public String intiateRequest(PaymentRequest paymentRequest);

}
