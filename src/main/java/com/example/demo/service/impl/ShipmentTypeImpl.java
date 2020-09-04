package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ShipmentType;
import com.example.demo.repository.ShipmentTypeRepository;
import com.example.demo.service.IShipmentTypeService;

@Service
public class ShipmentTypeImpl implements IShipmentTypeService{
	
	@Autowired
	private ShipmentTypeRepository repo;
	
	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType st) {
		// TODO Auto-generated method stub
		return repo.save(st).getId();
	}
	
	
	@Override
	@Transactional
	public void update(ShipmentType st) {
		repo.save(st);
		
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}
	
	
	
	@Override
	public Optional<ShipmentType> getOne(Integer id) {
	Optional<ShipmentType>opt=repo.findById(id);
		return opt;
	}
	
	@Override
	public List<ShipmentType> getAll() {
		List<ShipmentType>list=repo.findAll();
		return list;
	}
	
	
	@Override
	public boolean isExist(Integer id) {
		boolean exist=repo.existsById(id);
		return exist;
	}

}
