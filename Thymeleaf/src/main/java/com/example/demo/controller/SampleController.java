package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Member;

@Controller
public class SampleController {

	@RequestMapping("sample1")
	public String sample1(Model model) {		
//		model.addAttribute("greeting", "Hello World");
		model.addAttribute("greeting", "안녕 하세요");		
		return "sample1";
	}
	
	@RequestMapping("sample2")
	public String sample2(Model model) {
		Member member = new Member(1,"test","1234","홍길동", new Timestamp(System.currentTimeMillis()));
		
		model.addAttribute("member", member);
		
		return "sample2";
	}
	
	@RequestMapping("sample3")
	public String sample3(Model model) {
		List<Member> list = new ArrayList<Member>();
		
		for(int i=0; i<10; i++) {
			Member member = new Member(1,"test"+i,"1234","홍길동"+i, new Timestamp(System.currentTimeMillis()));			
			list.add(member);
		}		
		model.addAttribute("list", list);
		
		return "sample3";
	}
	
	@RequestMapping("sample4")
	public String sample4(Model model) {
		List<Member> list = new ArrayList<Member>();
		
		for(int i=0; i<10; i++) {
			Member member = new Member(i,"u000"+i %3,     // 3으로 나눈 나머지 id
					                     "p000"+i %3,     // 3으로 나눈 나머지 pw 
					                     "홍길동"+i, 
					                     new Timestamp(System.currentTimeMillis()));			
			list.add(member);
		}		
		model.addAttribute("list", list);
		
		return "sample4";
	}
	
	@RequestMapping("sample5")
	public String sample5(Model model) {
		
		String result = "SUCCESS";
		
		model.addAttribute("result", result);
		
		return "sample5";
	}
	
	@RequestMapping("sample6")
	public String sample6(Model model) {	
		
		model.addAttribute("now", new Date());
		model.addAttribute("price", 123456789);
		model.addAttribute("title", "This is a just sample");
		model.addAttribute("options", Arrays.asList("AAA","BBB","CCC","DDD"));
		
		return "sample6";
	}
	
	@RequestMapping("sample7")
	public String sample7(Model model) {	
		
		return "sample7";
	}
	
}
