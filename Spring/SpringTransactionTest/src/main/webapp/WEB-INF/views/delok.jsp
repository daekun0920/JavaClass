<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:if test = "${result == 1 }">
	게시물을 삭제했습니다.

</c:if>


<c:if test = "${result != 1 }">
	오류가 발생했습니다.

</c:if>