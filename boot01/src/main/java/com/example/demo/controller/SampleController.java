package com.example.demo.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller+@ResponseBody
@Controller
public class SampleController {
	
	
	@RequestMapping("/hi")
	@ResponseBody
	public void hello(HttpServletResponse response) throws IOException {
		response.getWriter().print("Hello world~!!!"); //웹 브라우저에 출력을 함으로써 콜백함수로 돌려줄 수 있다.
	}

	@RequestMapping("/abc")
	@ResponseBody //@ResponseBody: return값이 뷰페이지가 아닌 hi abc라는 값을 바로 브라우저에 돌려줌
	public String abc() {
		return "hi abc";
	}

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello in");
		return "hello";
	}

	@RequestMapping("/gugu")
	public String gugu(Model model) {
		Random r = new Random();
		int dan = r.nextInt(8)+2; // 2 ~ 9단
		
		model.addAttribute("dan", dan);
		return "gugu";
	}

}
