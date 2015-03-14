<%@page import="com.onc.reservation.Reser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="loginCheck.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String msg = (String) request.getAttribute("MSG");
	if (msg == null) {
		msg = "";
	}
%>

<script type="text/javascript">

/* $( "#stateChange" ).click(function() {
	  alert( "Handler for .click() called." );
	  
	}); */
	


</script>
<c:import url="header_common.jsp" charEncoding="UTF-8" />
<!-- topbar starts -->
<c:import url="header.jsp" charEncoding="UTF-8" />
<!-- topbar ends -->
<div class="ch-container">
	<div class="row">

		<!-- left menu starts -->
		<c:import url="snbMenu.jsp" charEncoding="UTF-8" />
		<!-- left menu ends -->

		<div id="content" class="col-lg-10 col-sm-10">
			<!-- content starts -->
			<div>
				<ul class="breadcrumb">
					<li><a href="#">Home</a></li>
					<c:if test="${param.state=='' }">
						<li><a href="listReservation.do">订单列表</a></li>
					</c:if>
					<c:if test="${param.state=='1' }">
						<li><a href="listReservation.do?state=1">订单列表</a></li>
					</c:if>
					<c:if test="${param.state=='2' }">
						<li><a href="listReservation.do?state=2">订单列表(预购)</a></li>
					</c:if>
					<c:if test="${param.state=='3' }">
						<li><a href="listReservation.do?state=3">订单列表(购入)</a></li>
					</c:if>
					<c:if test="${param.state=='4' }">
						<li><a href="listReservation.do?state=4">订单列表(断货)</a></li>
					</c:if>
				</ul>
			</div>
			<div>
				<c:set var="tPrice" value="0" />
				<c:set var="outPrice" value="0" />
				<c:forEach var="reser" items="${reserList }">
					<c:set var="tPrice"
						value="${reser.p_price*reser.p_count+tPrice}" />
					<c:set var="outPrice"
						value="${reser.p_outprice*reser.p_count+outPrice}" />
				</c:forEach>
				进:￦
				<fmt:formatNumber value="${tPrice }" type="number" />
				&nbsp;&nbsp;&nbsp;&nbsp; 出:￦
				<fmt:formatNumber value="${outPrice }" type="number" />
			</div>
			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">
						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i>
								<c:if test="${param.state=='' }">订单列表</c:if>
								<c:if test="${param.state=='1' }">订单列表</c:if>
								<c:if test="${param.state=='2' }">订单列表(预购)</c:if>
								<c:if test="${param.state=='3' }">订单列表(购入)</c:if>
								<c:if test="${param.state=='4' }">订单列表(断货)</c:if>
								&nbsp;&nbsp;&nbsp;&nbsp;
							</h2>

							<!--  <div class="box-icon">
                        <a href="#" class="btn btn-minimize btn-round btn-default"><i class="glyphicon glyphicon-chevron-up"></i></a>
                        <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                    </div> -->
						</div>
						<div class="box-content">
							<div style="margin-bottom: 5px">
								订单<span class="label label-info">${countAll }</span>， 预约<span
									class="label-success label label-default">${count1 }</span>， 购入<span
									class="label-warning label label-default">${count2 }</span>， 断货<span
									class="label-default label label-danger">${count3 }</span>
							</div>
							<table class="table table-striped table-bordered responsive">
								<thead>
									<tr>
										<th>商品名</th>
										<th>基本信息</th>
										<th>价格</th>
										<th>状态</th>
										<th>&nbsp;</th>
									</tr>
								</thead>
								<tbody>
									<%
										if (!msg.equals("")) {
									%>
									<tr>
										<td colspan="7"><%=msg%></td>
									</tr>
									<%
										} else {
									%>
									<c:forEach var="reser" items="${reserList }" varStatus="i">
										<tr>
											<td><a
												href="reserModifyForm.do?order_no=${reser.order_no }">${reser.p_name }</a><br />
												<c:choose>
													<c:when test="${reser.p_pic=='noimg'}">
                            			&nbsp;
                            		</c:when>
													<c:otherwise>
														<a href="reserModifyForm.do?order_no=${reser.order_no }">
															<img src="upload/${reser.p_pic }" alt="${reser.p_name }"
															style="height: 58px;" />
														</a>
													</c:otherwise>
												</c:choose></td>
											<td class="center">
												<%-- ${reser.o_date } --%> <fmt:formatDate pattern="MM-dd"
													value="${reser.o_date}" /><br /> 
													数量：<fmt:formatNumber value="${reser.p_count}" type="number" /><br />
													${reser.p_costmer }<br />
											</td>
											<td class="center">进:￦<fmt:formatNumber value="${reser.p_price}" type="number" /> / 个<br /> 
																进:￦<fmt:formatNumber value="${reser.p_price*reser.p_count}" type="number" /><br />
																出:￦<fmt:formatNumber value="${reser.p_outprice}" type="number" /> / 个<br /> 
																出:￦<fmt:formatNumber value="${reser.p_outprice*reser.p_count}" type="number" />
											</td>
											<td class="center" id="stateChange${i.index}"><c:choose>
													<c:when test="${reser.p_state==1 }">
														<span class="label label-default">预购</span>
													</c:when>
													<c:when test="${reser.p_state==2 }">
														<span class="label label-success">购入</span>
													</c:when>
													<c:when test="${reser.p_state==3 }">
														<span class="label label-warning">断货</span>
													</c:when>
													<c:when test="${reser.p_state==4 }">
														<span class="label label-info">删除</span>
													</c:when>
												</c:choose></td>
											<td class="center">
													<a class="btn btn-default btn-sm " style="margin-bottom:4px" onclick="goUpdate(${reser.order_no },1,${i.index})"> 
														<i class="glyphicon glyphicon-shopping-cart icon-white"></i> 预购
													</a>
													<a class="btn btn-danger btn-sm" style="margin-bottom:4px" onclick="goUpdate(${reser.order_no },3,${i.index})"> 
														<i class="glyphicon glyphicon-remove icon-white"></i> 断货
													</a>
													<br />
													 <a class="btn btn-success btn-sm" onclick="goUpdate(${reser.order_no },2,${i.index})"> 
													 	<i class="glyphicon glyphicon-check icon-white"></i> 购入
													</a>  
													<a class="btn btn-info btn-sm" onclick="goUpdate(${reser.order_no },4,${i.index})"> 
														<i class="glyphicon glyphicon-remove icon-white"></i> 删除
													</a>
											</td>
										</tr>
									</c:forEach>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!--/span-->

			</div>
			<!-- content ends -->
		</div>
		<!--/#content.col-md-0-->

	</div>
	<!--/fluid-row-->

	<c:import url="footer.jsp" charEncoding="UTF-8" />

	<c:import url="footer_common.jsp" charEncoding="UTF-8" />