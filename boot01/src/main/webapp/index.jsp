<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(document).ready(function(){
$("#sel").change(function(){
var sel = $("#sel").val();
location.href=sel;
});
});
</script>
</head>
<body>
선택 :
<select id="sel">
<option value="">메뉴</option>
<option value="hi">hi</option>
<option value="welcome">welcome</option>
<option value="abc">abc</option>
<option value="hello">hello</option>
<option value="gugu">구구단</option>
</select>
</body>
</html>
