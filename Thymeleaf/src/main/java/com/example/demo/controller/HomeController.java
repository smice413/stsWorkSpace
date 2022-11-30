package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/listTest")
	public void listTest(Model model) {
		
		List list = new ArrayList();
		
		for(int i=1; i<=20; i++) {
			list.add("Data:"+i);
		}
		
		model.addAttribute("name", "Sample Data");
		model.addAttribute("list", list);
	}
}
