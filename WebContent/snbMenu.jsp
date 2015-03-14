<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">菜单</li>
                        <li><a class="ajax-link" href="reserWrite.jsp"><i class="glyphicon glyphicon-plus-sign"></i><span> 添加订单</span></a>
                        </li>
                        <li><a class="ajax-link" href="listReservation.do?state=1"><i class="glyphicon glyphicon-shopping-cart"></i><span> 订单列表</span></a>
                        </li>
                        <li><a class="ajax-link" href="listReservation.do?state=2"><i class="glyphicon glyphicon-shopping-cart"></i><span> 订单(预约)</span></a>
                        </li>
                        <li><a class="ajax-link" href="listReservation.do?state=3"><i class="glyphicon glyphicon-check"></i><span> 订单(购入)</span></a>
                        </li>
                        <li><a class="ajax-link" href="listReservation.do?state=4"><i class="glyphicon glyphicon-remove"></i><span> 订单(断货)</span></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--/span-->
        
        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>