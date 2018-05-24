<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
<script>
	if (${result} == 1) {
		alert("글 작성이 완료 되었습니다.");
		location.href = "/enter/company/notice.do";
	} else {
		alert("글 작성을 실패했습니다.");
		location.href = "/enter/company/notice.do";
	}
</script>
</head>
<body>

</body>
</html>