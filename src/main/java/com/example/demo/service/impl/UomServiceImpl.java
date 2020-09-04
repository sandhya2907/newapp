package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Uom;
import com.example.demo.repository.UomRepository;
import com.example.demo.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private UomRepository repo;

	@Transactional
	@Override
	public Integer saveUom(Uom uom) {

		return repo.save(uom).getUomId();
	}

	@Override
	public List<Uom> getAllUom() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	@Transactional
	@Override
	public void deleteUom(Integer id) {
		repo.deleteById(id);
		
	}
	
	@Override
	public boolean isExistUom(Integer id) {
		boolean exist=repo.existsById(id);
		return exist;
	}
	
	
	@Override
	public Optional<Uom> getOne(Integer id) {
	Optional<Uom>opt=	repo.findById(id);
		return opt;
	}
	
	
	@Override
	public void updateUom(Uom uom) {
		repo.save(uom);
		
	}
}


