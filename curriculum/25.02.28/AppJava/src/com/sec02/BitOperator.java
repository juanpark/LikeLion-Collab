package com.sec02;
	public class BitOperator {
		
	
		public static void prn() {
			int a=51;
			int b=240;
			
			 System.out.println("AND = " + (a&b));
			 System.out.println("OR = " + (a|b));
			 System.out.println("XOR = " + (a^b));
		}
		
		
		public static void main(String[] args) {
			
			// integer to binary string
			
			int a=51;
			int b=240;
			
			System.out.printf("a = 51 to binary =  0b%016d \n", Integer.parseInt(Integer.toBinaryString(a)));
			System.out.printf("b = 240 to binary = 0b%016d \n", Integer.parseInt(Integer.toBinaryString(b)));
			
			System.out.printf("a = 51 to binary =  0b%16s \n", String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0'));
			System.out.printf("b = 240 to binary = 0b%16s \n", String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0'));
		
			String str01 = BinaryStringPadding(a);
			System.out.println(str01);
			
			String str02 = BinaryStringPadding(b);
			System.out.println(str02);

			String str03 = BinaryStringPadding(-20);
			System.out.println(str03);
			
			int res_a = 2;
			System.out.println(BinaryStringPadding(res_a));
			
			float res_aa = 7.2f;
			System.out.println(BinaryStringPadding(res_aa));
			
			
			// 실수 타입을 구현할 때  ->  실수클래스의 비트로 변환한 다음 정수 클래스의 toBinaryString으로 작성한다.
			// Double 클래스의 bits로 변환하는 메소드를 찾아보자 !!!
			double 	doubleValue = 3.14159265359; // 8bytes
			long 	bits = Double.doubleToLongBits(doubleValue); // 메소드 찾기 
			String 	binaryString = Long.toBinaryString(bits); // 변환하기 
			System.out.println(doubleValue +"\n"+ bits +"\n" + binaryString); //출력 
			
			System.out.println("=================== NaN ===================");
			
			double non_value = Double.NaN; // not a number : 0.0/0/0 -> NaN, Math.sqrt(-1) -> NaN
			long res03 = Double.doubleToLongBits(non_value);
			long res04 = Double.doubleToRawLongBits(non_value);
		
			System.out.println(non_value + "\n" + res03 + "\n" + res04);
			System.out.println(Long.toBinaryString(res03) + "\n" + Long.toBinaryString(res04));
			
			double non_value2 = 0.0 / 0.0;
			System.out.println(non_value2);
			
			
			
		}
		
		// method to convert integer to 32 digit binary string with 0 padding in the front
		public static String BinaryStringPadding(int res) {
			String result = String.format("%32s", Integer.toBinaryString(res)).replace(' ', '0');
			return result;
		}
		public static String BinaryStringPadding(float res) {
			String result = String.format("%32s", Float.floatToIntBits(res)).replace(' ', '0');
			return result;
		}
	}




	
	
