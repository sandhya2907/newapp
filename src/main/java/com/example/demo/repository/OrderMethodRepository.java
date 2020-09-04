package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderMethod;

public interface OrderMethodRepository extends JpaRepository<OrderMethod, Integer> {

}
