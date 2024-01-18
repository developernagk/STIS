package ch01;

public class B_Datatype {

	public static void main(String[] args) {
		
		// 기본형 데이터 타입
		
		// 정수형 데이터 타입: 실수부가 없는 정수를 나타냄
		// byte: 1byte(8bit)의 크기를 가지는 정수형 데이터 타입
		// -128 ~ 127
		byte byte1 = 127;
		// byte byte2 = 128;
		
		// short: 2byte(16bit)의 크기를 가지는 정수형 데이터 타입
		// -32768 ~ 32767
		short short1 = 32767;
		// short short2 = 32768; mismatch 컴파일에러
		
		// int: 4byte(32bit)의 크기를 가지는 정수형 데이터 타입
		// -2147483648 ~ 2147483647
		int int1 = 2_147_483_647;
		// int int2 = 2_147_483_648; outofrange 컴파일에러
		
		// long: 8byte(64bit)의 크기를 가지는 정수형 데이터 타입
		long long1 = 2_147_483_648L; // 숫자 끝에 소문자인 l 혹은 대문자인 L을 적어줘야 함

	}

}
