<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- deptList.do 요청한 결과 페이지(deptList.jsp)의 table태그만 불러옴 -->
<script type="text/javascript">
	$(function() {
		$('#list').load("deptList.do table"); 
		/* .load()함수는 deptList.do의 모든 데이터중 table 태그에 있는 것만 가져와서 id="list"인 태그에 넣어라는 의미 */
	});
</script>
</head>
<body>
	<div class="container">
		<h2>부서 상세정보</h2>
		<table class="table table-bordered">
			<tr>
				<th>부서코드</th>
				<td>${dept.deptno}</td>
			</tr>
			<tr>
				<th>부서명</th>
				<td>${dept.dname }</td>
			</tr>
			<tr>
				<th>근무지</th>
				<td>${dept.loc }</td>
			</tr>
			<tr>
				<th colspan="2"><a href="deptList.do" class="btn btn-info">목록</a>
					<a href="deptUpdateForm.do?deptno=${dept.deptno}" class="btn btn-info">수정</a> 
					<a href="deptDelete.do?deptno=${dept.deptno}" class="btn btn-info">삭제</a></th> 
					<!-- 삭제가 안되는 500번 오류가 발생하는데 이는 emp테이블의 deptno foreign key 제약조건 설정시 on delete cascade설정을 하지 않았기 때문 -->
			</tr>
		</table>
	</div>
	<div id="list"></div>
</body>
</html>