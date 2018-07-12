<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<%--jdbc:mysql://120.79.221.143:3306/bookstore?characterEncoding=utf8 --%>
  </head>
  
  <body>
   				<div class="pagination">
									<ul>


										<li class="disablepage"><a href="${pageContext.request.contextPath  }/searchBooksServlet?currentPage=${pb.currentPage==1?1:pb.currentPage-1}">&lt;&lt;上一页</a></li>
										
										
										<li>第${pb.currentPage }页/共${pb.totalPage }页</li>

										<li class="nextPage"><a href="${pageContext.request.contextPath  }/searchBooksServlet?currentPage=${pb.currentPage==pb.totalPage?pb.totalPage:pb.currentPage+1}">&lt;&lt;下一页</a></li>


									</ul>
								</div>
  </body>
</html>
