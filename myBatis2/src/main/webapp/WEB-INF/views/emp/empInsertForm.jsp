<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		// 사번 중복 검사
		$('#dupCheck').click(function() {
			var empno = $('#empno').val(); //사원번호
			if (!empno) {
				alert('사번 입력후에 체크');
				$('#empno').focus();
				return false;
			}// $.post("요청이름","전달될 값","콜백함수"); 비동기적 처리
			$.post('dupCheck.do', 'empno=' + empno, function(msg) {
				alert(msg); //dupCheck.jsp에서 출력된 ${msg}가 매개변수로 콜백되어 alert로 출력됨.
			});
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h2 class="text-primary">직원 등록</h2>
		<form action="empInsert.do" method="post">
			<table class="table table-bordered">
				<tr>
					<td>사번</td>
					<td><input type="number" name="empno" required="required"
							   id="empno" autofocus="autofocus"> 
						<input type="button" value="중복" id="dupCheck"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="ename" required="required"></td>
				</tr>
				<tr>
					<td>업무</td>
					<td><input type="text" name="job" required="required"></td>
				</tr>
				<tr>
					<td>관리자</td>
					<td><select name="mgr">
							<c:forEach var="emp" items="${empList }">
								<option value="${emp.empno}">${emp.ename}</option>
								<!-- 출력되는 것은 직속상관의 사원명이 출력되지만 선택 후 가지고 가는 값은 사원번호다. -->
							</c:forEach>
					    </select>
					</td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="date" name="hiredate" required="required"></td>
				</tr>
				<tr>
					<td>급여</td>
					<td><input type="number" name="sal" required="required"></td>
				</tr>
				<tr>
					<td>보너스</td>
					<td><input type="number" name="comm" required="required"></td>
				</tr>
				<tr>
					<td>부서코드</td>
					<td><select name="deptno">
							<c:forEach var="dept" items="${deptList }">
								<option value="${dept.deptno}">${dept.dname}</option>
								<!-- 화면에 출력되는 값은 부서명 선택하면 가지고 넘어가는 값은 부서번호  -->
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>