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
		基于云的复杂计算系统
    </div>
    
    <div class = "topnav">
		    <a href = "#matrix">行列式计算</a>
		    <a href = "#linerRegression">线性回归</a>
    </div>
    <div id = context>
    </div>
    
    
    <div id = "matrix">
	<p class = "center">
		请在下方输入框按顺序输入行列式的所有元素，各元素之间用逗号分开
		</p>		
	<form style="text-align:center;height:25px;font-size:26px;" action="TestServlet" method="post" onsubmit="return calc(this);">
		<input style="text-align:center;height:25px;font-size:26px;" type="text" name="matrixData" size="40"/>
			<br>
		<input class="btn-blue" type="submit" value="计算" />
			<br>
    <p style="text-align:center;height:25px;font-size:26px;">
			${originalMatrix}
			<br>
			${betValue}
		</p>
		</form>
	</div>
	<div id = "linerRegression">
		
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
	
	<!--  <div id="timeShow" class="footer"></div>
	-->
	
			<!--
	<script type="text/javascript">
     	var t = null;
    	t = setTimeout(time,1000);//开始执行
   		function time()
		    {
		       clearTimeout(t);//清除定时器
		       dt = new Date();
			   var y=dt.getYear()+1900;
			   var mm=dt.getMonth()+1;
			   var d=dt.getDate();
			   var weekday=["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
			   var day=dt.getDay();
	           var h=dt.getHours();
    	       var m=dt.getMinutes();
        	   var s=dt.getSeconds();
				if(h<10){h="0"+h;}
				if(m<10){m="0"+m;}
				if(s<10){s="0"+s;}
		        document.getElementById("timeShow").innerHTML =  ""+y+"年"+mm+"月"+d+"日"+""+weekday[day]+""+h+":"+m+":"+s+"";
		        t = setTimeout(time,1000); //设定定时器，循环执行
	    }
		</script>
		-->
</html>
