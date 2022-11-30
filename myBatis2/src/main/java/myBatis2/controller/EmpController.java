package myBatis2.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import myBatis2.model.Dept;
import myBatis2.model.Emp;
import myBatis2.service.DeptService;
import myBatis2.service.EmpService;

@Controller
public class EmpController {
	@Autowired //어노테이션을 반드시 개별적으로 따로따로 써야함
	private EmpService es;
	@Autowired
	private DeptService ds;
	
	// 각 부서에 소속된 직원을 구하는 요청
	@RequestMapping("empList.do")
	public String empList(int deptno, Model model) {
		Dept dept = ds.select(deptno);
		List<Emp> list = es.list(deptno);
		model.addAttribute("dept", dept);
		model.addAttribute("list", list);
		return "emp/empList"; //prefix의 value값으로 들어간 최상위 디렉토리 말고 나머지 디렉토리는 써줘야함. emp폴더까지 추가하면 경로 못 찾음. 무조건 views폴더 까지만
	}
	
	// 부서직원 등록 폼
	@RequestMapping("empInsertForm.do")
	public String empInsertForm(Model model) {
		List<Dept> deptList = ds.list();	// 부서목록
		List<Emp> empList = es.empList();	// 사원목록
		model.addAttribute("deptList", deptList);
		model.addAttribute("empList", empList);
		return "emp/empInsertForm";
	}
	
	// 사번 중복 검사 
	@RequestMapping("dupCheck.do")
	public String dupCheck(int empno, Model model) {
		System.out.println("empno:"+empno);
		Emp emp = es.select(empno);
		String msg = "";
		if (emp != null) // 중복 사번
			msg = "이미 있는 데이터입니다";
		else			// 사용 가능한 사번
			msg = "사용 가능한 사번 입니다";
		model.addAttribute("msg", msg); // 웹브라우저에 출력되는 값이 call back함수의 매개변수로 리턴됨.
		return "emp/dupCheck";
	}
	
	// 사원 등록
	@RequestMapping("empInsert.do")
//	public String empInsert(Emp emp, String hiredate1, Model model) {
	public String empInsert(Emp emp, Model model) {
//		emp.setHiredate(Date.valueOf(hiredate1)); // String -> Date 형변환
		int result = es.insert(emp);
		model.addAttribute("result", result);
		model.addAttribute("deptno", emp.getDeptno()); //가입 후 소속된 부서의 상세페이지로 가게 하기 위함
		return "emp/empInsert";
	}
	
	// 직원 상세 페이지
	@RequestMapping("empView.do")
	public String empView(int empno, Model model) {
		Emp emp = es.select(empno);
		model.addAttribute("emp", emp);
		return "emp/empView";
	}
	
	// 직원 삭제
	@RequestMapping("empDelete.do")
	public String empDelete(int empno, Model model) {
		Emp emp = es.select(empno);
		int result = es.delete(empno);
		model.addAttribute("result", result);
		model.addAttribute("deptno", emp.getDeptno()); //삭제한 후 부서페이지로 가기 위함
		return "emp/empDelete";
	}
	
	// 직원 수정 폼
	@RequestMapping("empUpdateForm.do")
	public String empUpdateForm(int empno, Model model) {
		Emp emp = es.select(empno);				// 사원 상세 정보 구하기
		List<Dept> deptList = ds.list();		// 부서 목록
		model.addAttribute("emp", emp);
		model.addAttribute("deptList", deptList);
		return "emp/empUpdateForm";
	}

	// 직원 정보 수정	
	@RequestMapping("empUpdate.do")
	public String empUpdate(Emp emp, Model model) {
		int result = es.update(emp);
		model.addAttribute("deptno", emp.getDeptno());
		model.addAttribute("result", result);
		return "emp/empUpdate";
	}
	
	// 전체 직원 목록(등가조인)
	@RequestMapping("empAllList.do")
	public String empAllList(Model model) {
		List<Emp> list = es.empAllList();
		model.addAttribute("list", list);
		return "emp/empAllList";
	}
}


