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

import com.example.demo.model.Uom;
import com.example.demo.service.IUomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@RequestMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("uom", new Uom());
		return "UomRegisterPage";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom, Model model) {
		Integer id = service.saveUom(uom);
		String message = "Uom '" + id + "' saved";
		model.addAttribute("msg", message);
		model.addAttribute("uom", new Uom());
		return "UomRegisterPage";

	}

	@RequestMapping("/all")
	public String fetchAllUom(Model model) {
		List<Uom> list = service.getAllUom();
		model.addAttribute("list", list);
		return "UomData";

	}

	@RequestMapping("/delete/{id}")
	public String removeUomById(@PathVariable Integer id, Model model) {
		String msg = null;
		if (service.isExistUom(id)) {
			service.deleteUom(id);
			msg = "Uom is '" + id + "' deleted";
			
		} else {
			msg = "Uom is '" + id + "'  not exist";
		}
		model.addAttribute("message", msg);
		// show other rows
		List<Uom> list = service.getAllUom();
		model.addAttribute("list", list);
		return "UomData";

	}
	
	@RequestMapping("/edit/{id}")
	public String EditShipmentType(@PathVariable Integer id,Model model) {
		String page=null;
		Optional <Uom>opt=service.getOne(id);
		if(opt.isPresent()) {
			Uom uom=opt.get();
			//form backing object
			model.addAttribute("uom", uom);
			page="UomTypeEdit";
		}else {
			//id not exist
			page="redirect.../all";
		}
		
		return page;
		
	}
	
	
	
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public String updateUom(@ModelAttribute Uom uom,Model model) {
		service.updateUom(uom);
		String message="Uom type data is '"+uom.getUomId()+"' updated";
		model.addAttribute("message", message);
		//fetch new data
		List<Uom> list = service.getAllUom();
		model.addAttribute("list", list);
		return "UomData";
		
	}
	
	
	
	
}
