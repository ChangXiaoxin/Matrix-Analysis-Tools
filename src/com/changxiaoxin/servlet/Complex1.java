package com.changxiaoxin.servlet;

import java.util.Scanner;
public class Complex1 { // žŽÊýÀà
	double real;  // Êµ²¿
	double image; // Ðé²¿

Complex1(){
		Scanner input = new Scanner(System.in);
		double real = input.nextDouble();
		double image = input.nextDouble();
		Complex1(real,image);

	}
	private void Complex1(double real, double image) { // ¹©²»Žø²ÎÊýµÄ¹¹Ôì·œ·šµ÷ÓÃ
		// TODO Auto-generated method stub
		this.real = real;
		this.image = image;
		}

	Complex1(double real,double image){ // Žø²ÎÊýµÄ¹¹Ôì·œ·š
		this.real = real;
		this.image = image;	}

	public double getReal() {
		return real;	}
	public void setReal(double real) {
		this.real = real;	}
	public double getImage() {
		return image;	}
	public void setImage(double image) {
		this.image = image;	}



	Complex1 add(Complex1 a){ // žŽÊýÏàŒÓ
		double real2 = a.getReal();
		double image2 = a.getImage();
		double newReal = real + real2;
		double newImage = image + image2;
		Complex1 result = new Complex1(newReal,newImage);
		return result;	}

	Complex1 sub(Complex1 a){ // žŽÊýÏàŒõ

			double real2 = a.getReal();
			double image2 = a.getImage();
			double newReal = real - real2;
			double newImage = image - image2;
			Complex1 result = new Complex1(newReal,newImage);
			return result;	}

	Complex1 mul(Complex1 a){ // žŽÊýÏà³Ë
		double real2 = a.getReal();
		double image2 = a.getImage();
		double newReal = real*real2 - image*image2;
		double newImage = image*real2 + real*image2;
		Complex1 result = new Complex1(newReal,newImage);
		return result;	}

	Complex1 div(Complex1 a){ // žŽÊýÏà³ý
		double real2 = a.getReal();
		double image2 = a.getImage();
		double newReal = (real*real2 + image*image2)/(real2*real2 + image2*image2);
		double newImage = (image*real2 - real*image2)/(real2*real2 + image2*image2);		Complex1 result = new Complex1(newReal,newImage);
		return result;	}

	public void print(){ // Êä³ö
		if(image > 0){
			System.out.println(real + " + " + image + "i");
			}else
				if(image < 0){
				System.out.println(real + "" + image + "i");
				}else{
					System.out.println(real);		}
	}

}
