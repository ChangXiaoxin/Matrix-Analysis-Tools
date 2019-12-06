package com.changxiaoxin.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "行列式在线计算器", urlPatterns = { "/TestServlet" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String str = "{\"name\":\"" + name + "\",\"sex\":\"" + sex + "\",\"age\":" + age + "}";
		response.getWriter().write(str);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String account = request.getParameter("account");
//		String psd = request.getParameter("psd");

//		if(account.equals("admin") && psd.equals("123456")) {
//			request.getRequestDispatcher("test1.jsp").forward(request, response);
//		}else if(account.equals("admin") && !psd.equals("123456")) {
//			request.setAttribute("psdErrorString", "password is error");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}else if(!account.equals("admin") && psd.equals("123456")) {
//			request.setAttribute("accountErrorString", "account is error");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}else {
//			request.setAttribute("errorString", "login error");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}


//		StringBuffer buffer = new StringBuffer();
//		buffer.append( "<font size=4 color=blue align=center>交易记录</font>" );
//		buffer.append( "<form name=\"form1\" method=\"post\">" );
//		//其它代码略
//		//……
//		buffer.append( "</form>" );
//
//		request.setAttribute( "result", buffer );
//		request.getRequestDispatcher( "index.jsp" ).forward( request, response );


		String str = account;
		String[] arr = str.split(",");
		StringBuffer buffer = new StringBuffer();
		double[] det1 = new double[arr.length];
		for(int i=0;i<arr.length;i++){
			det1[i]=Double.parseDouble(arr[i]);
		}
		int n = (int) Math.sqrt(arr.length);
		double[][] det = new double[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				det[i][j]=det1[i*n+j];
			}
		}
		buffer=display(det);
		double outcome = detcalc(det);
		request.setAttribute("errorString", "行列式的值为:"+outcome);
		request.setAttribute( "result", buffer );
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public static double detcalc(double [][]det){
		int n = det.length;
		double prodL=1,prodU=1;
		double[][] L = new double[n][n];
		double[][] U = new double[n][n];
		for(int k=0;k<n;k++){
			for(int i=k+1;i<n;i++){
				det[i][k]=det[i][k]/det[k][k];
			}
			for(int i=k+1;i<n;i++){
				for(int j=k+1;j<n;j++){
					det[i][j]=det[i][j]-det[i][k]*det[k][j];
				}
			}
			det=changeline(det);
		}
		for(int i=0;i<n;i++){
			prodU*=det[i][i];

		}
		double result = prodU*prodL;
		if(Double.isNaN(result)){
			System.out.print(0.0);
			result=0.0;
			String output = String.valueOf(result);
		}
		else{
			System.out.println(result);
//			String output = String.valueOf(result);
		}
		return result;
	}
	public static double[][] changeline(double[][] det){
		int n=det.length;
		double[] temp=new double[n];
		for(int i=1;i<n;i++){
			if(det[i][i]==0){
				for(int k=i+1;k<n;k++){
					if(det[k][i]!=0){
						for(int j=0;j<n;j++){
							temp[j]=det[i][j];
						}
						for(int j=0;j<n;j++){
							det[i][j]=det[k][j];
						}
						for(int j=0;j<n;j++){
							det[k][j]=temp[j];
						}
					}
				}
				for(int j=0;j<n;j++){
					det[0][j]=-det[0][j];
				}

			}
		}
		return det; }
	public static StringBuffer display(double[][] det){
		StringBuffer buffer = new StringBuffer();
		buffer.append( "输入的原行列式为：<br>" );

		int n = det.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				buffer.append(det[i][j]+" ");
				buffer.append("&nbsp;");
				System.out.print(det[i][j]+" ");
			}
			System.out.println();
			buffer.append("<br>");
		}
		return buffer;
	}
}
