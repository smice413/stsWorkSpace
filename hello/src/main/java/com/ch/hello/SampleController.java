package com.ch.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller + @ResponseBody
@Controller
public class SampleController {
	@RequestMapping("/sample")
	@ResponseBody//이 어노테이션을 써야 DTO값을 json으로 바꿔줌 
	public SampleVo sample() {
		SampleVo sv = new SampleVo();
		sv.setMno(23);
		sv.setFirstName("홍");
		sv.setLastName("길동");
		return sv; // 요청한 곳에 콜백함수처럼 값을 돌려준다. 그러면 json형태의 key, value값으로 출력된다.(jackson라이브러리가 하는 것). 비동기적 처리
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<SampleVo> list() {
		List<SampleVo> list = new ArrayList<SampleVo>();
		for (int i = 1; i <= 10; i++) {
			SampleVo sv = new SampleVo();
			sv.setMno(i);
			sv.setFirstName("홍");
			sv.setLastName("길동" + i);
			list.add(sv);
		}
		return list;
	}
}