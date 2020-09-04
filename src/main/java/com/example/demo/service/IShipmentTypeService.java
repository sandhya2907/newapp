package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.ShipmentType;

public interface IShipmentTypeService {
	Integer saveShipmentType(ShipmentType st);

	void update(ShipmentType st);

	void delete(Integer id);

	Optional<ShipmentType> getOne(Integer id);
	
	List<ShipmentType>getAll();
	
	boolean isExist(Integer id);
	
	

}
