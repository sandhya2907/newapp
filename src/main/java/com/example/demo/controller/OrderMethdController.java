package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.OrderMethod;
import com.example.demo.service.IOrderMethodService;

@Controller
@RequestMapping("/om")
public class OrderMethdController {
	
	/**
	 * @param model
	 * @return
	 */
	@Autowired
	private IOrderMethodService service;
	
	
	@RequestMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("om", new OrderMethod());
		return "OmRegisterPage";
		
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveOrderMethod(@ModelAttribute OrderMethod om,Model model) {
		Integer id=service.saveOrderMethod(om);
		String message="Order method '"+id+"' saved";
		model.addAttribute("msg", message);
		model.addAttribute("om", new OrderMethod());
		return "OmRegisterPage";
		
	}

}
