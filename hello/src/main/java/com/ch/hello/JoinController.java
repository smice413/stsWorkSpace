package com.ch.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JoinController {
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	@RequestMapping("/join") // @ModelAttribute은 DTO클래스로 값을 받아오는  어노테이션
	public String join(@ModelAttribute Member member, Model model) {
		model.addAttribute("member", member);
		return "joinResult";
	}
}