package com.sec02.exam;

public class c_Nan {

	public static void main(String[] args) {
		// 자바에서는 nan을 처리해주는 다양한메소드들을 제공해준다.  
		// java.lang.Double  메소드에서 처리해준다.  
	   double  x=  0.0 /0.0 ;
	   double  x1=  Math.sqrt(-1);
	   double  x2=  Math.log(-1);
	   System.out.println(x  +"\t" + x1+"\t " + x2); 

	}

}
