package com.springboot.saikiran.dto;

import lombok.Data;

@Data
public class PaymentRequest 
{
	private String fullName;
	private String email;
	private String mobileNumber;
	private String course;
	private int courseFee;
	private String currency;

}
