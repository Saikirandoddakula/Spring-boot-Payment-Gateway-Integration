package com.springboot.saikiran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.saikiran.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity,String>
{

}
