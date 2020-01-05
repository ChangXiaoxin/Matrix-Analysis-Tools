<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
	<meta charset="UTF-8">
	<title>Matrix</title>
	</head>
<body>
	<div class = "header">
		行列式计算工具
    </div>
       <div id = context>
    </div>
      <div class = "topnav">
      		<a href = "index.jsp">首页</a>
		    <a href = "matrix.jsp">行列式计算</a>
		    <a href = "linear.jsp">线性回归</a>
		    <a href = "impedanceMatch.jsp">阻抗匹配计算</a>
		    <a href = "filter.jsp">滤波器设计</a>
      </div>

    <div id = "matrix">
	<p class = "center">
		请在下方输入框按顺序输入行列式的所有元素，各元素之间用英文逗号分开
		</p>
	<form class = "form" action="TestServlet?meth=matrix" method="post" onsubmit="return calc(this);">
		<!--<TEXTAREA class = "form" type="text" rows = "3" name="matrixData" size="40"></TEXTAREA>-->
                <TD><TEXTAREA name="matrixData" rows=3 cols=36>1,2,3,4</TEXTAREA>
                <br>
		<input class="btn-blue" type="submit" value="计算" />
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
