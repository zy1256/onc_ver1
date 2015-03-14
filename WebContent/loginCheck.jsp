<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:if test="${empty(sessionScope.login_user_id) }">
	<c:redirect url="login.jsp"/>
</c:if>       
