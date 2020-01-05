<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" type="text/css" href="mystyle.css">
	<meta charset="UTF-8">
	<title>Linear Regression</title>
	</head>
<body>

	<div class = "header">
		线性回归计算
    </div>
     <div class = "topnav">
    		<a href = "index.jsp">首页</a>
		    <a href = "matrix.jsp">行列式计算</a>
		    <a href = "linear.jsp">线性回归</a>
		    <a href = "impedanceMatch.jsp">阻抗匹配计算</a>
		    <a href = "filter.jsp">滤波器设计</a>
    </div>

    <div id = context>
    </div>

    <p class="center">请在下方输入框按顺序分别输入训练集的所有元素，各元素之间用英文逗号分开</p>

	<div id = "linearRegression">

        <TABLE width="385" height="487" >
               <TBODY>
               <TR>
                 <TD>
                   <DIV id=input>
                   <TABLE style="MARGIN: 0px; WIDTH: 100%">
                     <TBODY>
                     <TR>
                       <TD vAlign=center ><LABEL><BR>X:</LABEL></TD>
                       <TD><TEXTAREA id=xinputs rows=3 cols=40>1,2,3,4,5,6,7,8</TEXTAREA>
                        </TD></TR>
                     <TR>
                       <TD vAlign=center><LABEL><BR>Y:</LABEL></TD>
                       <TD><TEXTAREA id=yinputs rows=3 cols=40 name="S1">11,23,45,65,78,98,113,148</TEXTAREA>
                         </TD></TR>
                     <TR>
                       <TD align=middle></TD>
                       <TD><INPUT class = "btn-blue" onclick=calculate() value=计算 type=button></TD>
                       <TD></TD></TR></TBODY></TABLE></DIV></TD></TR>

               <TR>
                 <TD>
                   <DIV id=res_area>
                   <TABLE>
                     <TBODY>

                       <TD><LABEL>训练集数量</LABEL></TD>
                       <TD><INPUT id=result1 class=result disabled type=text size="32">
                       </TD></TR>
                     <TR>
                       <TD>拟合斜率<LABEL> B</LABEL></TD>
                       <TD><INPUT id=result2 class=result disabled type=text size="32">
                       </TD></TR>
                     <TR>
                       <TD><LABEL>平均值 X</LABEL></TD>
                       <TD><INPUT id=result5 class=result disabled type=text size="32">
                       </TD></TR>
                     <TR>
                       <TD><LABEL>平均值 Y</LABEL></TD>
                       <TD><INPUT id=result6 class=result disabled type=text size="32">
                       </TD></TR>
                     <TR>
                       <TD><LABEL>拟合截距 A</LABEL></TD>
                       <TD><INPUT id=result3 class=result disabled type=text size="32">
                       </TD></TR>
                     <TR>
                       <TD><LABEL>回归方程式 Y</LABEL></TD>
                       <TD><INPUT id=result4 class=result disabled type=text size="32">
                       </TD></TR></TBODY></TABLE></DIV></TD></TBODY></TABLE></DIV>
    <!----------------------------------------------------------->

      <SCRIPT type=text/javascript src = "linear.js"></SCRIPT>

    <!----------------------------------------------------------->

    </body>

</html>
