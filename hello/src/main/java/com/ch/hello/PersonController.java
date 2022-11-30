package com.ch.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	@RequestMapping("/addr") //@RequestParam("name")은 jsp에서 전달된 값을 받아 매개변수에 저장하라는 의미. 어노테이션이 없더라도 값이 전달된 것은 변수명이 같기 때문이다
	public String addr(@RequestParam("name") String name, @RequestParam("addr") String addr, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		return "addr";
	}

	@RequestMapping("/addr2")
	public String addr2(@ModelAttribute Person p, Model model) {
		
		System.out.println("name:"+ p.getName());
		System.out.println("addr:"+ p.getAddr());
		
		model.addAttribute("person", p);
		return "addr2";
	}
}