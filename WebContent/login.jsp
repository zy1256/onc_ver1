<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
/* String msg=(String)request.getAttribute("MSG");
if(msg==null){
	msg="请输入账号与密码";
} */
%>
 <c:import url="header_common.jsp" charEncoding="UTF-8" />
 
<div class="ch-container">
    <div class="row">
        
    <div class="row">
        <div class="col-md-12 center login-header">
            <h2>Welcome to ONC</h2>
        </div>
        <!--/span-->
    </div><!--/row-->

    <div class="row">
        <div class="well col-md-5 center login-box">
        <c:choose>
        	<c:when test="${MSG==null }">
	            <div class="alert alert-info">
	                请输入账号与密码
	            </div>
        	</c:when>
        	<c:otherwise>
	            <div class="alert alert-danger">
	                ${MSG }
	            </div>
        	</c:otherwise>
        </c:choose>
            <form class="form-horizontal" action="login.do" method="post">
                <fieldset>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" class="form-control" name="user_id" placeholder="账号">
                    </div>
                    <div class="clearfix"></div><br>

                    <div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                        <input type="password" class="form-control" name="user_pw" placeholder="密码">
                    </div>
                    <div class="clearfix"></div>
                    <p class="center col-md-5">
                        <button type="submit" class="btn btn-primary">登陆</button>
                    </p>
                </fieldset>
            </form>
        </div>
        <!--/span-->
    </div><!--/row-->
</div><!--/fluid-row-->

</div><!--/.fluid-container-->
 
 <c:import url="footer_common.jsp" charEncoding="UTF-8" />

