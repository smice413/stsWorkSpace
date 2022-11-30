package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration //기존 boot가 아닌것은 servlet-context.xml에서 했지만 클래스를 따로 생성해서 @Configuration 어노테이션을 써서 인터셉터가 실행이 되게 한다.
public class SessionCheckInter extends HandlerInterceptorAdapter {
	
	// preHandle(request,response,handler)메소드
	// 1.Controller에서 요청(*.do)을 받기 전에  preHandle()가 호출되어 가로채는 역할로 사용
	// 2.로그인 하지않고(세션이 없으면) 요청하면 로그인 폼으로 이동 하도록 해주는 역할
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if (id == null || id.equals(""))  {		
			response.sendRedirect("member_login.do");	// 세션이 없으면 로그인 폼으로 이동
			return false;
		}
		return true;
	}
}