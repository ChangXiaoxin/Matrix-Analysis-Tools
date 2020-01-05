
package com.changxiaoxin.servlet;

import java.util.Scanner;

//import java.util.Scanner;

public class match {


	public static double[] main(double Zlr,double Zli,double Z0,double f ) {
		Complex1 data1 = new Complex1(Zlr,Zli);
		Complex1 data2 = new Complex1(Z0,0);
        double result[]={0,0,0,0,0};
        

	if(data1.getImage()==0 && data2.getImage()==0) {
		Complex1 mul = data1.mul(data2);
        Complex1 sub = data1.sub(data2);
		Complex1 add = data1.add(data2);
		Complex1 Ref = sub.div(add);
        double mRef = Math.sqrt(Ref.getImage()*Ref.getImage()+Ref.getReal()*Ref.getReal());
		double VSWR = (1 + mRef)/(1 - mRef);
        result[0]=Math.sqrt(Zlr*Z0);
		System.out.println("Z0l = "+ Math.sqrt(mul.real));
        result[1]= Ref.real;
        result[2]= 0;
        result[3]= VSWR;
        result[4]= 0;
	}
	else
		if(data1.getImage()!=0 && data2.getImage()==0 ){
		//ŒÆËãÖÕ¶Ë·ŽÉäÏµÊý
		Complex1 sub = data1.sub(data2);
		Complex1 add = data1.add(data2);
		Complex1 Ref = sub.div(add);
		System.out.print("·ŽÉäÏµÊýRef=");
		Ref.print();
		//ŒÆËã×€²š±È
		double mRef = Math.sqrt(Ref.getImage()*Ref.getImage()+Ref.getReal()*Ref.getReal());
		double VSWR = (1 + mRef)/(1 - mRef);
		System.out.println("×€²š±ÈVSWR="+ VSWR);

		//ŒÆËãÆ¥ÅäŽ«ÊäÏßµÄÌØÐÔ×è¿¹
		System.out.println("×è¿¹±ä»»Æ÷µÄÌØÐÔ×è¿¹ZolÎª£º" + data2.getReal()*Math.sqrt(VSWR));
		//ŒÆËã×è¿¹±ä»»Æ÷ÀëÖÕ¶ËµÄŸàÀëz
		double aRef = Math.atan2(Ref.getImage(), Ref.getReal());
		double c = 3*Math.pow(10,8);
		double z = (c*aRef)/(f*4*Math.PI);
		System.out.println("×è¿¹±ä»»Æ÷ÀëÖÕ¶ËµÄŸàÀëzÎª£º" + z);

        result[0] = data2.getReal()*Math.sqrt(VSWR);
        result[1] = Ref.getReal();
        result[2] = Ref.getImage();
        result[3] = VSWR;
        result[4] = z;
	}
	return result;

}
}
