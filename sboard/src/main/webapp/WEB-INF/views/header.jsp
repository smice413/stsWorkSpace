<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ${pageContext.request.contextPath } 현재 프로젝트명 구하기 -->
<c:set var="path" value="${pageContext.request.contextPath }" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${path}/css/bootstrap.min.css" rel="stylesheet">
<script src="${path}/js/jquery.js"></script>
<script src="${path}/js/bootstrap.min..js"></script>
<style>
.err {
	color: red;
	font-size: 20px;
}
</style>