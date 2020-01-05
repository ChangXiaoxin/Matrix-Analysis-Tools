
package com.changxiaoxin.servlet;
import java.lang.Math;
	public class fsd_LPF {
	    public static Complex[] fft(Complex[] x) {
		int N = x.length;

		// base case
		if (N == 1)
		    return new Complex[] { x[0] };

		// radix 2 Cooley-Tukey FFT
		if (N % 2 != 0) {
		    throw new RuntimeException("N is not a power of 2");
		}

		// fft of even terms
		Complex[] even = new Complex[N / 2];
		for (int k = 0; k < N / 2; k++) {
		    even[k] = x[2 * k];
		}
		Complex[] q = fft(even);

		// fft of odd terms
		Complex[] odd = even; // reuse the array
		for (int k = 0; k < N / 2; k++) {
		    odd[k] = x[2 * k + 1];
		}
		Complex[] r = fft(odd);

		// combine
		Complex[] y = new Complex[N];
		for (int k = 0; k < N / 2; k++) {
		    double kth = -2 * k * Math.PI / N;
		    Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
		    y[k] = q[k].plus(wk.times(r[k]));
		    y[k + N / 2] = q[k].minus(wk.times(r[k]));
		}
		return y;
	    }

	    // compute the inverse FFT of x[], assuming its length is a power of 2
	    public static Complex[] ifft(Complex[] x) {
		int N = x.length;
		Complex[] y = new Complex[N];

		// take conjugate
		for (int i = 0; i < N; i++) {
		    y[i] = x[i].conjugate();
		}

		// compute forward FFT
		y = fft(y);

		// take conjugate again
		for (int i = 0; i < N; i++) {
		    y[i] = y[i].conjugate();
		}

		// divide by N
		for (int i = 0; i < N; i++) {
		    y[i] = y[i].scale(1.0 / N);
		}

		return y;

	    }
		public static double[] fsd_LPF(int fs,int fc){
			double Wc=0;
			double pi=Math.PI;
			double[] Wm=new double[64];
			double[] Hd=new double[64];
			Complex[] H=new Complex[128];
			double[] out=new double[128];
			int s1=0,s2=0;
			Wc=2*pi*fc/fs;
			int N=127;
			Complex a = new Complex(0.0, 0.0);
			for (int m=0;m<(N+1)/2;m++){
				Wm[m]=2*pi*m/128;
			}
			for (int n=0;n<(N+1)/2;n++){
				if(Wm[n]>=Wc){
					Hd[n]=0;
				}else{
					Hd[n]=1;
				}
			}
			int s11=(int) Math.floor(Wc*128/(2*pi))-1;
			int s21=(int) Math.floor(Wc*128/(2*pi));
			Hd[s11]=0.5886;
			Hd[s21]=0.1065;
			for (int m=0;m<(N+1)/2;m++){
				Wm[m]*=63.5;
				Complex b = new Complex(Hd[m], 0.0);
				Complex c = new Complex(Math.cos(Wm[m]),Math.sin(-Wm[m]));
				H[m]=b.times(c);
			}
			for (int m=0;m<(N+1)/2-1;m++){
				H[127-m]=H[m+1].conjugate();
			}
			H[64]=a.times(a);
			Complex[] h = ifft(H);
			for (int i=0;i<128;i++){
				out[i]=h[i].re();
			}
	/*		for(int i=0;i<128;i++){
				System.out.print(out[i]+" ");
			System.out.println();}*/
			return out;

		}
		public static void main(String[] args){
			double[] h = fsd_LPF(1000,250);
		}
	}
