<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html style="background:pink">
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
	<meta charset="UTF-8">
	<title>bet-calculate</title>
	</head>

<body>
	<div id="timeShow" class="time1"></div>
	<h1 style="text-align:center;">
		行列式在线计算工具
    </h1>
	<p style="text-align:center;">
		请在下方输入框按顺序输入行列式的所有元素，各元素之间用逗号分开
		</p>
	<script type="text/javascript">
		function calc(form){
			with(form){
				if(account.value == ""){
					alert("请输入行列式!!!");
					return false;
				}
			}
		}
		</script>
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
	<form style="text-align:center;height:25px;font-size:26px;" action="TestServlet" method="post" onsubmit="return calc(this);">
		<input style="text-align:center;height:25px;font-size:26px;" type="text" name="account" size="40"/>
			${accountErrorString }
			<br>
		<input class="btn-blue" type="submit" value="计算" />
			<br>
    <p style="text-align:center;height:25px;font-size:26px;">
			${result}<br>
			${errorString}
		</p>
		</form>
	</body>
</html>
