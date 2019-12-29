<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
	<meta charset="UTF-8">
	<title>bet-calculate</title>
	</head>
<body>
	<div class = "header">
		线性回归计算
    </div>
     <div class = "topnav">
    		<a href = "index.jsp">首页</a>
		    <a href = "matrix.jsp">行列式计算</a>
		    <a href = "liner.jsp">线性回归</a>
    </div> 
   
    <div id = context>
    </div>
    
    
	<div id = "linerRegression">
		<p class = "center">
		请在下方输入框按顺序输入训练集的所有元素，各元素之间用逗号分开
		</p>		
	<form class = "form" action="TestServlet?meth=liner" method="post" onsubmit="return liner(this);">
		<input class = "form" type="text" name="linerRegressionData" size="40"/>
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
		
			with(form){
				if(linerRegressionData.value == ""){
					alert("请输入训练集!!!");
					return false;
				}
			}
		}
		</script>
	
</html>
