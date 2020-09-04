package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Uom;

public interface IUomService {
	Integer saveUom(Uom uom);

	List<Uom> getAllUom();

	void deleteUom(Integer id);

	boolean isExistUom(Integer id);

	Optional<Uom> getOne(Integer id);

	void updateUom(Uom uom);

}
