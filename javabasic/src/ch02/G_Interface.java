package ch02;

// 인터페이스: 클래스가 구현해야만 하는 메서드들을 선언하는 참조 타입
// 인터페이스의 모든 변수는 public static final 형태가 와야 함
// 인터페이스의 모든 메서드는 public abstract 형태가 와야 함 (default나 static 메서드가 올 수 있음)
// 인터페이스는 다중 구현이 가능

// 접근제어자 interface 인터페이스명 { ... }

// 넓이 공식
// 삼각형 넓이 구하기 - double 밑변, double 높이 -> double 삼각형넓이
// 정사각형 넓이 구하기 - double 변 -> double 정사각형넓이
// 직사각형 넓이 구하기 - double 밑변, double 높이 -> double 직사각형넓이
// 원 넓이 구하기 - double 반지름 -> double 원넓이 // 변하지 않고 고정적인 값은 제외

interface AreaCalculation {
	
	public static final double PI = 3.14;
	
	public abstract double getTrinangleArea (double bottom, double height);
	public abstract double getSquareArea (double side);
	public abstract double getRectangleArea (double bottom, double height);
	public abstract double getCircleArea (double radius);
	
}

// 인터페이스는 implements 키워드를 이용해서 클래스에 구현해야 함
class MyMath implements AreaCalculation {

	@Override
	public double getTrinangleArea(double bottom, double height) {
		return bottom * height / 2;
	}

	@Override
	public double getSquareArea(double side) {
		return side * side;
	}

	@Override
	public double getRectangleArea(double bottom, double height) {
		return bottom * height;
	}

	@Override
	public double getCircleArea(double radius) {
		return radius * radius * PI;
	}
	
}

class MyMathV2 implements AreaCalculation {
	@Override
	public double getTrinangleArea(double bottom, double height) {
		return bottom * height / 2;
	}

	@Override
	public double getSquareArea(double side) {
		return Math.pow(side, 2);
	}

	@Override
	public double getRectangleArea(double bottom, double height) {
		return bottom * height;
	}

	@Override
	public double getCircleArea(double radius) {
		return radius * radius * PI;
	}
}

public class G_Interface {

	public static void main(String[] args) {
		
		// 기능에 대한 참조 변수를 선언할 경우 인터페이스로 선언하면 코드의 안정성이 향상
		AreaCalculation instance = new MyMathV2();
		

	}

}
