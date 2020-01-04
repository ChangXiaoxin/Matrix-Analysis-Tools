<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
	<meta charset="UTF-8">
	<title>Filter</title>
	</head>
<body>
	<div class = "header">
		滤波器设计工具
    </div>
       <div id = context>
    </div>
      <div class = "topnav">
      		<a href = "index.jsp">首页</a>
		    <a href = "matrix.jsp">行列式计算</a>
		    <a href = "linear.jsp">线性回归</a>
		    <a href = "impedanceMatch.jsp">等效阻抗计算</a>
		    <a href = "filter.jsp">滤波器设计</a>
    </div>

    <div id = "filter">
	<p class = "center">
		滤波器设计输入
		</p>
	<form class = "form" action="TestServlet?meth=filter" method="post" onsubmit="return calc(this);">
		<input class = "form" type="text" name="matrixData" size="40"/>
			<br>
		<input class="btn-blue" type="submit" value="计算" />
			<br>
    <p class = "form">
			${originalMatrix}
			<br>
			${betValue}
		</p>
		</form>
	</div>



	</body>

	<script type="text/javascript">
		function calc(form){
			with(form){
				if(matrixData.value == ""){
					alert("请输入行列式!!!");
					return false;
				}
			}
		}
	</script>
</html>
