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
        <img style="margin-left:20%;" width="800px" height="200px" src="filter.jpg" alt="fiter">
		<p class = "center">
		    请在下方输入所有参数的值
		</p>
	<form class = "form" action="TestServlet?meth=match" method="post" onsubmit="return linear(this);">
		Z0:  <input name ="Z0R" style="width:50px;font-size: 24px;height:25px"> + </input><input style="width:50px;font-size: 24px; height:25px" name="Z0I"> j</input>	<br>
        Zl :  <input name="ZlR" style="width:50px;font-size: 24px;height:25px"> + </input><input style="width:50px;font-size: 24px; height:25px" name="ZlI"> j</input>  <br>
        l  : <input name="lent" style="width:130px;font-size: 24px; height:25px"></input>    <br>
        <br>
        <input class="btn-blue" type="submit" value="计算" />
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
				if(Z0I.value == ""||Z0R.value ==""||ZlR.value == ""||ZlI.value==""||l.value==""){
					alert("请输入所有参数!!!");
					return false;
				}
			}
		}
		</script>

</html>
