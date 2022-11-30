package myBatis1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import myBatis1.model.Dept;
import myBatis1.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	private DeptService ds;
	
	// 부서 목록
	@RequestMapping("deptList.do")
	public String list(Model model) {
		List<Dept> list = ds.list();
		model.addAttribute("list", list);
		return "deptList";
	}
	// 부서 상세 페이지
	@RequestMapping("deptView.do")
	public String deptView(int deptno, Model model) { 
		//매개 변수 앞에 @RequestParam("deptno")을 해야하지만 값을 전달하는 변수명과 받는 변수명이 일치하기 때문에 안써도 바로 값을 받을 수 있다.
		//그리고 어노테이션으로 값을 받을 때 String 형으로 받게 되지만 굳이 integer.parsaint를 하지 않아도 int로 써두면 알아서 처리된다.
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "deptView";
	}
	// 수정 폼
	@RequestMapping("deptUpdateForm.do")
	public String deptUpdateForm(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		model.addAttribute("dept", dept);
		return "deptUpdateForm";
	}
	
	// 수정
	@RequestMapping("deptUpdate.do")
	public String deptUpdate(@ModelAttribute Dept dept, Model model) {
		int result = ds.update(dept);
		model.addAttribute("result", result);
		return "deptUpdate";
	}
	// 삭제
	@RequestMapping("deptDelete.do")
	public String deptDelete(int deptno, Model model) {
		int result = ds.delete(deptno);
		model.addAttribute("result", result);
		return "deptDelete";
	}
}