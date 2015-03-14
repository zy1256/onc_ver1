<%@page import="com.onc.reservation.Reser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="loginCheck.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
        <li>
            <a href="#">Home</a>
        </li>
        <li>
            <a href="reserWrite.jsp">添加订单</a>
        </li>
    </ul>
</div>

<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> 添加订单</h2>
            </div>
            <div class="box-content">
						<!-- 	private int order_no;
							private Date o_date;
							private String p_name;
							private int p_count;
							private int p_price;
							private String p_pic;
							private String p_costmer;
							private int p_state; -->
                <form role="form" name="newReser" action="reserWrite.do" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="exPic">商品图片</label>
                        <input type="file" id="exPic" name="p_pic">
                    </div>
                    <div class="form-group">
                        <label for="exName">商品名称</label>
                        <input type="text" class="form-control" id="exName" name="p_name" placeholder="商品名" required="required" >
                        <input type="hidden" class="form-control" name="user_no" value="${ sessionScope.login_user.user_no}" />
                    </div>
                    <div class="form-group">
                        <label for="exCount">商品数量</label>
                        <input type="number" class="form-control" id="exCount" name="p_count" placeholder="数量" value="1">
                    </div>
                    <div class="form-group">
                        <label for="exPrice">商品进货价格</label>
                        <input type="number" class="form-control" id="exPrice" name="p_price" placeholder="商品进货价格" value="0">
                    </div>
                    <div class="form-group">
                        <label for="exPrice">商品出货价格</label>
                        <input type="number" class="form-control" id="exOutPrice" name="p_outprice" placeholder="商品出货价格" value="0">
                    </div>
                    <div class="form-group">
                        <label for="exCoustmer">客户名</label>
                        <input type="text" class="form-control" id="exCoustmer" name="p_costmer" placeholder="客户名" >
                    </div>
                    <div class="form-group">
	                    <label class="radio-inline">
	                    	<input type="radio" name="p_state" id="inlineRadio1" value="1" checked="checked"> 预购
	                	</label>
	                    <label class="radio-inline">
	                    	<input type="radio" name="p_state" id="inlineRadio2" value="2"> 购入
	                	</label>
	                    <label class="radio-inline">
	                    	<input type="radio" name="p_state" id="inlineRadio3" value="3"> 断货
	                	</label>
	                    <!-- <label class="radio-inline">
	                    	<input type="radio" name="p_state" id="inlineRadio4" value="4"> 发货
	                	</label> -->
                    </div>
                    <button type="submit" class="btn btn-default">确认添加</button>
                </form>

            </div>
        </div>
    </div>
    <!--/span-->

</div><!--/row-->

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
    
</div><!--/fluid-row-->

<c:import url="footer.jsp" charEncoding="UTF-8" />
 
 <c:import url="footer_common.jsp" charEncoding="UTF-8" />

