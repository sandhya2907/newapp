package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.ShipmentType;
import com.example.demo.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipmentType")
public class ShipmentTypeController {
	
	@Autowired
	private IShipmentTypeService service;
	
	
	
	@RequestMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("shipment", new ShipmentType());
	
		return "ShipmentTypeRegister";
		
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute ShipmentType shipmentType,Model model) {
		Integer id=service.saveShipmentType(shipmentType);
		String message="Data '"+id+"' saved";
		model.addAttribute("msg",message);
		model.addAttribute("shipment", new ShipmentType());
		return "ShipmentTypeRegister";
		
	}
	
	
	@RequestMapping("/all")
	public String fetchAllShipmentType(Model model) {
		List<ShipmentType>list=service.getAll();
		model.addAttribute("list", list);
		return "ShipmentData";
		
	}
	@RequestMapping("/delete/{id}")
	public String removeById(@PathVariable Integer id,Model model) {
		String msg=null;
		if(service.isExist(id)) {
			service.delete(id);
			msg="ShipmentType '"+id+"' deleted";
		}else {
			msg="ShipmentType '"+id+"'not exist";
		}
		model.addAttribute("message", msg);
		//show other rows
		List<ShipmentType>list=service.getAll();
		model.addAttribute("list",list);
		
		return "ShipmentData";
		
	}
	
	@RequestMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id,Model model) {
		String page=null;
	Optional<ShipmentType>opt=	service.getOne(id);
	if(opt.isPresent()) {
		ShipmentType st=opt.get();
		//form backing object with data
		model.addAttribute("shipmentType", st);
		page="ShipmentTypeEdit";
	}else {
		//id not exist
		page="redirect.../all";
	}
		return page;
		
		
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {

		service.update(shipmentType);

		String message = "shipmentType'" + shipmentType.getId() + "'updated";

		model.addAttribute("message", message);

		// fetch new data
		List<ShipmentType> list = service.getAll();

		model.addAttribute("list", list);

		return "ShipmentData";
	}


}
