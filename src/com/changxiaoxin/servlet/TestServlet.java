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

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("meth");
        if (method.endsWith("matrix")) {//矩阵计算
        	this.matrix(request, response);
        }else if(method.endsWith("linear")) {//线性回归
        	this.linear(request, response);
        }else if(method.endsWith("match")) {//阻抗匹配
        	this.impedanceMatch(request,response);
        }else if(method.endsWith("filter")) {//滤波设计
        	this.filter(request, response);
        }

	}

	//--------------------------<矩阵计算>-------------------------------
	//------------------------------------------------------------------
	public void matrix(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String str = request.getParameter("matrixData");
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
		request.setAttribute( "originalMatrix", buffer );
		request.setAttribute("betValue", "行列式的值为:"+outcome);
		request.getRequestDispatcher("matrix.jsp").forward(request, response);
	}
	//------------------------------------------------------------------
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
	//---------------------------------------------------------------------
	//------------------------------</矩阵计算>------------------------------



	//------------------------------<线性回归>------------------------------
	//--------------------------------------------------------------------
	public void linear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String trainset = request.getParameter("linearRegressionData");

		double theta[]=LinearRegression.main(null);
		String theta0=new java.text.DecimalFormat("#.0").format(theta[0]);
		String theta1=new java.text.DecimalFormat("#.0").format(theta[1]);
		//String theta2=new java.text.DecimalFormat("#.00").format(theta[2]);
		request.setAttribute( "regressionValue", "误差：     R^2 = " + theta[2]);
		request.setAttribute("originalTrainSet", "回归线公式:  y = " + theta0 + "x + " + theta1 );
		request.getRequestDispatcher("linear.jsp").forward(request, response);
	}
	//----------------------------------------------------------------------






	//------------------------------------------------------------------
	//---------------------------</线性回归>-----------------------------

	//----------------------------<阻抗匹配>-----------------------------
	//-----------------------------------------------------------------
	public void impedanceMatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	//------------------------------------------------------------------



	//------------------------------------------------------------------
	//-----------------------------</阻抗匹配>----------------------------



	//------------------------------<滤波设计>----------------------------
	//-------------------------------------------------------------------
	public void filter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String Sfs = request.getParameter("Fs");
			String Sfc = request.getParameter("Fc");
			String out2="";
			int fs =Integer.parseInt(Sfs);

			int fc =Integer.parseInt(Sfc) ;

			double[] out = fsd_LPF.fsd_LPF(fs, fc);
			for(int i=0;i<128;i++){
			String out0=new java.text.DecimalFormat("#.000000").format(out[i]);
			out2 = out2+"<br>"+out0;
			}
			request.setAttribute("result",out2);
			request.getRequestDispatcher("filter.jsp").forward(request, response);
	}
	//-------------------------------------------------------------------



	//---------------------------------------------------------------------
	//------------------------------</滤波设计>-----------------------------
}
