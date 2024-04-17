package ch02;

// 기타 제어자(비접근 제어자): 접근 제어와 무관하게 동작을 제어하는 것

// final 제어자: 
// - 클래스: final 제어자가 붙은 클래스는 확장(상속)할 수 없음
// - 메서드: final 제어자가 붙은 메서드는 오버라이드할 수 없음
// - 변수: final 제어자가 붙은 변수는 재할당할 수 없음

final class FinalModifier1 {
	int variable;
}

//class SubModifier1 extends FinalModifier1 {
//	
//}

class FinalModifier2 {
	
	final void method () {}
	
}

class SubModifier2 extends FinalModifier2 {
	
//	void method () {}
	
}

class FinalModifier3 {
	
	final int variable = 10;
	
	void method () {
//		variable = 20;
	}
	
}


// static 제어자:
// - 메서드: static 제어자가 붙은 메서드는 인스턴스 생성 없이 클래스로 바로 호출 가능
// - 변수: static 제어자가 붙은 변수는 인스턴스 생성 없이 클래스로 바로 접근 가능

class StaticModifier {
	
	static int variable;
	
	static void method () {}
	
}

// (모든) 제어자의 조합
class Combination {
	
	// public + static + final (주로 사용)
	public static final int NUMBER = 10;
	
	// 메서드에서 private + final X
	// 어느 곳에서든 접근 불가능한 private, 오버라이드 할 수 없는 final(private 상태일 때 굳이 final을 붙이지 않음)
	private final void method () {}
	
	// 메서드에서 private + abstract X (서로 상충)
	// 어느 곳에서든 접근 불가능한 private, 반드시 오버라이드 해야하는 abstract
	
	// 클래스와 메서드에서 final + abstract X 
	// 오버라이드 할 수 없는 final(확장 불가능), 반드시 오버라이드 해야하는 abstract(확장 필요)
	
	
}

public class D_Modifier {

	public static void main(String[] args) {
		StaticModifier.variable = 0;
		StaticModifier.method();

	}

}
