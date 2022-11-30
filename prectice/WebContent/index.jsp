<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="fileupload.action">
<table border="1">
	<caption>파일 업로드</caption>
	<tr>
		<th>설명</th>
		<td>
		<input type="text" name="description" autofocus="autofocus">
		</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>
		<input type="file" name="file" required="required">
		</td>
	</tr>
	<tr>
	<td>
	<input type="submit" value="확인">
	</td>
	</tr>
</table>
</form>
</body>
</html>