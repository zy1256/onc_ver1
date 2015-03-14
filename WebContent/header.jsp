<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="loginCheck.jsp"%>


    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <!-- <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button> -->
            <a class="navbar-brand"> <img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs"/>
                <span>Charisma</span></a>

            <!-- user dropdown starts -->
			<div class="btn-group pull-right">
			    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
			        <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> <c:out value="${sessionScope.login_user.user_name}" />
			        <input type="hidden" name="sessionUserNo" value="${sessionScope.login_user.user_no}" />
			        </span>
			        <span class="caret"></span>
			    </button>
			    <ul class="dropdown-menu">
			   <!--      <li><a href="#">Profile</a></li>
			        <li class="divider"></li> -->
			        <li><a href="logout.do">Logout</a></li>
			    </ul>
			</div>

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li>
                <c:if test="${sessionScope.login_user.user_adm==1}">
                    <form class="navbar-search pull-left" action="searchResult.do">
                        <input type="hidden" name="stateP" value="${param.state }" />
                        <input placeholder="Search" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
                </c:if>
                </li>
            </ul>

        </div>
    </div>