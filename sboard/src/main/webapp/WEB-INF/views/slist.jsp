<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('.edit1').click(function() {		// 수정 버튼, this는 이벤트를 발생시킨 태그를 의미함 즉, 수정버튼을 말함
			var id  = $(this).attr('id');  // rno
			var txt = $('#td_'+id).text(); // replytext   // id='tt_"+id+"' : textarea도 구분하기 위해 id값을 부여함
			$('#td_'+id).html("<textarea rows='3' cols='30' id='tt_"+id+"'>"+txt
				+"</textarea>");
			$('#btn_'+id).html(
			   "<input type='button' value='확인' onclick='up("+id+")'> "
			  +"<input type='button' value='취소' onclick='lst()'>");
		});
	});
	function up(id) {// 내용 수정
		var replytext = $('#tt_'+id).val();		// 수정된 글내용
		var formData = "rno="+id+'&replytext='+replytext
			+"&bno=${board.num}";
		$.post('${path}/repUpdate',formData, function(data) {
			$('#slist').html(data);
		});
	}
	function lst() {// 취소
		$('#slist').load('${path}/slist/num/${board.num}');
	}
	function del(rno,bno) {	//삭제 버튼
		var formData="rno="+rno+"&bno="+bno;
		$.post("${path}/repDelete",formData, function(data) {
			alert(data);
			$('#slist').html(data);
		});
	}
</script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">댓글</h2>
		<table class="table table-bordered">
			<tr>
				<td>작성자</td>
				<td>내용</td>
				<td>수정일</td>
				<td></td>
			</tr>
			<c:forEach var="rb" items="${slist}">
				<tr>
					<td>${rb.replyer}</td>
					<!-- 수정버튼 클릭시 ${rb.replytext}을 위의 스크립트 함수로 textarea에 출력되도록 함. -->
					<td id="td_${rb.rno}">${rb.replytext}</td> 
					<td>${rb.updatedate }</td>
					<td id="btn_${rb.rno}">
						<c:if test="${rb.replyer==board.writer }">
							<input type="button" value="수정" class="edit1" id="${rb.rno}">
							<input type="button" value="삭제"	 onclick="del(${rb.rno},${rb.bno})">
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>