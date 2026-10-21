package com.springboot.saikiran.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity 
{
	private String fullName;
	@Id
	private String email;
	private String mobileNumber;
	private String course;
	private int courseFee;
	private String currency;

}
