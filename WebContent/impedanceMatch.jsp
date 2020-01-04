<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
	<meta charset="UTF-8">
	<title>Impedance Match</title>
	</head>
<body>
	<div class = "header">
		传输线等效阻抗计算
    </div>
     <div class = "topnav">
    		<a href = "index.jsp">首页</a>
		    <a href = "matrix.jsp">行列式计算</a>
		    <a href = "linear.jsp">线性回归</a>
		    <a href = "impedanceMatch.jsp">等效阻抗计算</a>
		    <a href = "filter.jsp">滤波器设计</a>
    </div>

    <div id = context>
    </div>


	<div id = "impedanceMatch">
		<p class = "center">
		电磁波阻抗匹配输入
		</p>
	<form class = "form" action="TestServlet?meth=match" method="post" onsubmit="return linear(this);">
		<input class = "form" type="text" name="linearRegressionData" size="40"/>
			<br>
		<input class="btn-blue" type="submit" value="拟合" />
			<br>
    <p class = "form">
			${originalTrainSet}
			<br>
			${regressionValue}
		</p>
		</form>
	</div>
	</body>

	<script type="text/javascript">
		function linear(form){
			with(form){
				if(linearRegressionData.value == ""){
					alert("请输入训练集!!!");
					return false;
				}
			}
		}
		</script>

</html>
