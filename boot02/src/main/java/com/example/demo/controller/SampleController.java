package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Member;

@Controller
public class SampleController {

	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("send")
	public String send(Member member, Model model) {
		System.out.println("id:"+member.getId());
		System.out.println("passwd:"+member.getPasswd());
		
		
		
		model.addAttribute("member", member);
		
		return "result";
	}
}
