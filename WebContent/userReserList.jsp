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

<c:import url="header_common.jsp" charEncoding="UTF-8" />
<!-- topbar starts -->
<c:import url="header.jsp" charEncoding="UTF-8" />
<!-- topbar ends -->
<div class="ch-container">
	<div class="row">

		<!-- left menu starts -->
		<%-- <c:import url="snbMenu.jsp" charEncoding="UTF-8" /> --%>
		<!-- left menu ends -->

		<div id="content" class="col-lg-12 col-sm-12">
			<!-- content starts -->
			<div>
				<ul class="breadcrumb">
					<li><a>Home</a></li>
						<li><a>订单列表</a></li>
				</ul>
			</div>
			<div>
				<c:set var="tPrice" value="0" />
				<c:set var="outPrice" value="0" />
				<c:forEach var="reser" items="${reserList }">
					<c:set var="outPrice"
						value="${reser.p_outprice*reser.p_count+outPrice}" />
				</c:forEach>
				总额：￦
				<fmt:formatNumber value="${outPrice }" type="number" />
			</div>
			<div class="row">
				<div class="box col-md-12">
					<div class="box-inner">
						<div class="box-header well" data-original-title="">
							<h2>
								<i class="glyphicon glyphicon-user"></i>
								订单列表
							</h2>

							<!--  <div class="box-icon">
                        <a href="#" class="btn btn-minimize btn-round btn-default"><i class="glyphicon glyphicon-chevron-up"></i></a>
                        <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                    </div> -->
						</div>
						<div class="box-content">
							<div style="margin-bottom: 5px">
								订单<span class="label label-info">${countAll }</span>， 
								预约<span class="label label-default">${count1 }</span>， 
								购入<span class="label-success label label-default">${count2 }</span>
							</div>
							<table class="table table-striped table-bordered responsive">
								<thead>
									<tr>
										<th>商品名</th>
										<th>基本信息</th>
										<th>价格</th>
										<th>状态</th>
										<th>图片</th>
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
											<td>${reser.p_name }
												</td>
											<td class="center">
												<%-- ${reser.o_date } --%> <fmt:formatDate pattern="MM-dd"
													value="${reser.o_date}" /><br /> 
													数量：<fmt:formatNumber value="${reser.p_count}" type="number" /><br />
											</td>
											<td class="center">
												单价：￦<fmt:formatNumber value="${reser.p_outprice}" type="number" /> / 个<br /> 
												总价：￦<fmt:formatNumber value="${reser.p_outprice*reser.p_count}" type="number" />
											</td>
											<td class="center" id="stateChange${i.index}"><c:choose>
													<c:when test="${reser.p_state==1 }">
														<span class="label label-default">预购</span>
													</c:when>
													<c:when test="${reser.p_state==2 }">
														<span class="label label-success">购入</span>
													</c:when>
												</c:choose>
											</td>
											<td>
												<c:choose>
													<c:when test="${reser.p_pic=='noimg'}">
				                            			&nbsp;
				                            		</c:when>
													<c:otherwise>
															<img src="upload/${reser.p_pic }" alt="${reser.p_name }"
															style="width:80px" />
													</c:otherwise>
												</c:choose>
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