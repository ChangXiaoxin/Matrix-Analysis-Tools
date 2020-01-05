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
		    <a href = "impedanceMatch.jsp">阻抗匹配计算</a>
		    <a href = "filter.jsp">滤波器设计</a>
    </div>

    <div id = "filter">
    <p class="code">Matlab现实代码：<br>
n=linspace(0,pi,1000);%用于产生0,pi之间的1000点行矢量<br>
H=freqz(h,[1],n);%滤波器的幅频特性图<br>
subplot(2,1,1);<br>
plot(n/pi,abs(H));<br>
xlabel('归一化角频率');ylabel('|H(e^(jw))|');title('幅频响应');<br>
axis([0 1 0 1.2]);<br>
subplot(2,1,2);<br>
plot(n/pi,20*log10(abs(H)));%参数分别是归一化频率与幅值<br>
xlabel('归一化角频率');ylabel('20log|H(e^(jw))|');title('幅频响应（dB）');<br>
axis([0 1 -100 20]);<br>
            <p>
		<p class = "center">
		    请在下方输入所有参数的值
		</p>
	<form class = "form" action="TestServlet?meth=filter" method="post" onsubmit="return filter(this);">
		Fs(采样频率):  <input name ="Fs" style="width:100px;font-size: 24px;height:25px">	<br>
        Fc(截止频率):  <input name="Fc" style="width:100px;font-size: 24px;height:25px"> <br>
        <br>
        <input class="btn-blue" type="submit" value="计算" />

    <p class = "form">
			${result}

		</p>
		</form>
	</div>




	</body>

	<script type="text/javascript">
		function filter(form){
			with(form){
				if(Fs.value == ""||Fc.value==""){
					alert("请输入参数!!!");
					return false;
				}
			}
		}
	</script>
</html>
