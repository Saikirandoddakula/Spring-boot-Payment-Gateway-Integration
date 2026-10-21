package com.springboot.saikiran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.saikiran.dto.PaymentRequest;

@Service
public class PaymentInterfaceImpl implements PaymentService
{
	private StripeGatewayService stripeService;
	
	@Autowired
	public PaymentInterfaceImpl(StripeGatewayService stripeService)
	{
		this.stripeService=stripeService;
	}
	
	
	
	public String intiateRequest(PaymentRequest paymentRequest)
	{
		String email=paymentRequest.getEmail();
		String course= paymentRequest.getCourse();
		int amount= paymentRequest.getCourseFee();
		String currency= paymentRequest.getCurrency();
		
		return stripeService.createCheckoutSession(email,course,amount,currency);
	}

}
     	