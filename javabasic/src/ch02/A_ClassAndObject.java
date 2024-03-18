package ch02;

// 클래스: 공통된 속성과 기능을 하나로 정의해둔 것
// [접근제어자] class 클래스명 { 속성, 기능 }
// 클래스를 선언할 때는 클래스 외부에서 선언
class ExampleClass1 {
	// 속성: 클래스가 가질 수 있는 정보나 상태
	// 일반적으로 변수로 표현
	// 인스턴스 변수
	// 각 인스턴스마다 독립적으로 값을 가지는 변수
	int attribute1; // 인스턴스 변수
	double attribute2;
	
	// 클래스 변수(스테틱 변수, 정적 변수)
	// 해당 클래스로 생성된 모든 인스턴스가 공유하는 변수
	// 속성 앞에 static 키워드를 사용하여 지정할 수 있음
	static int staticAttribute;
	
	// 기능: 클래스가 가질 수 있는 행동이나 작업(메서드)
	// 클래스로 생성된 객체를 통해서 호출이 가능
	// [접근제어자 일반제어자] 반환타입 메서드명(매개변수타입 매개변수명[, ...]) -- 선언부
	// { 메서드 기능 구현 } -- 구현부
	
	
	// 매개변수 : O, 반환값 : O
	int method1 (int arg1, int arg2) {
		// 기능 구현
		// 반환타입이 void가 아니면 반드시 return으로 결과를 반환해야 함
		return 0;
	}
	// 매개변수 : X, 반환값 : O
	int method2 () {
		return 0;
	}
	// 매개변수 : O, 반환값 : X
	void method3 (int arg1) {
		// void에서의 return은 강제로 메서드를 종료하기 위해 사용
		return;
	}
	// 매개변수 : X, 반환값 : X
	void method4 () {
		System.out.println(attribute1); // 인스턴스 메서드에 인스턴스 변수
		System.out.println(staticAttribute); // 인스턴스 메서드에 스테틱 변수
		
		method2(); // 인스턴스 메서드에 인스턴스 메서드
		staticMethod(); // 인스턴스 메서드에 스테틱 메서드
	}
	
	// 클래스 메서드(스테틱 메서드. 정적 메서드)
	// 모든 인스턴스가 공유하는 메서드
	// 반환타입 앞에 static 키워드를 붙여서 사용
	static void staticMethod () {
		// static 메서드에서는 instance 변수 접근 및 instance 메서드 호출이 불가능
//		System.out.println(attribute1); // 스테틱 메서드에 인스턴스 변수
		System.out.println(staticAttribute); // 스테틱 메서드에 스테틱 변수
		
//		method2(); // 스테틱 메서드에 인스턴스 메서드
//		staticMethod(); // 스테틱 메서드에 스테틱 메서드
		
		}
	// 생성자: 클래스의 인스턴스를 생성하는 순간에 호출되는 메서드
	// 클래스와 같은 이름을 가지고 있고, 반환타입이 존재하지 않음(무조건 인스턴스 반환)
	// 클래스명 ([매개변수, ...]) { 인스턴스가 생성될 때 할 작업 }
	
//	ExampleClass1 (int arg1, double arg2) { 
//		// 인스턴스 초기화 과정에서 매개변수로 외부에서 값을 입력받는 것(의존성을 외부에서 주입했다.)
//		System.out.println("ExampleClass1 인스턴스 생성!!");
//		// 의존성이 내부에서 주입하는 형태
//		// 속성 값이 생성 이전에 결정이 되었기 때문에 코드의 안정성이 저하
////		attribute1 = 99;
////		attribute2 = -99.99;
//		
//		// 의존성을 외부에서 주입하는 형태
//		// 속성 값이 생성 당시에 결정되기 때문에 코드의 안정성을 향상
//		attribute1 = arg1;
//		attribute2 = arg2;
//		// 인스턴스 변수 자체를 생성자 매개변수에 넣어주면 이름이 같기 때문에 알고 쓰기 편함
//		// ExampleClass1 (int attribute1, double arg2) { ... }
//		// this.attribute1 = attribute1 // 좌항은 인스턴스 변수, 우항은 매개변수
//		// attribute2 = arg2
//		// 그냥 'attribute = attribute'만 적으면 좌항과 우항 모두 매개변수로 인식
//		// 인스턴스 변수 앞에는 this.을 붙여 인스턴스 변수를 인식하게 함
//		// 클래스에 생성된 클래스명'{ ... }'에 있는 것을 인식
//		// this 키워드: 자기 인스턴스를 지칭
////		this.staticMethod(); // 스테틱 메서드에도 사용 가능
//	}
	
	// 오버로딩: 같은 클래스 내에서 같은 이름의 메서드를 여러 개 작성할 수 있도록 하는 방법
	// 오버로딩 조건
	// 1. 메서드 이름을 중복해서 작성하지만 매개변수의 타입 및 개수를 다르게 작성
	// 2. 메서드의 반환타입과 메서드의 매개변수의 이름은 오버로딩에 영향을 미치지 않음
	void overloadMethod () {
		
	}
	// 매개변수 개수
	void overloadMethod (int arg) {
		
	}
	// 매개변수 타입
	void overloadMethod (double arg) {
		
	}
	// 매개변수 조합
	void overloadMethod (int arg1, double arg2) {
		
	}
	
	void overloadMethod (double arg1, int arg2) {
		
	}
	// 반환타입이 다르기에 에러 발생
//	int overloadMethod (double arg1, int arg2) {
//		return 0;
//	}
	// 매개변수의 이름이 다르기에 에러 발생
//	void overloadMethod (double double1, int int1) {
//		
//	}
	// Non argument Constructor
	// 생성자도 메서드의 일종이기 때문에 오버로딩이 가능
	ExampleClass1() {
		this.attribute1 = 99;
		this.attribute2 = -99.99;
	}
	
	ExampleClass1(int attribute1) {
//		this(attribute1. -99.99); // 생성자, 위의 생성자를 작동시켜야 이것도 오류 안 일어남
//		this.attribute1 = attribute1;
//		this.attribute2 = -99.99;
	}
}



// 축구선수 	(FootballPlayer)

// 이름 		(name - string)
// 포지션 	(Position - String)
// 생년월일	(birth - String)
// 키		(height - double)
// 몸무게		(weight - double)
// 국적		(country - String)
// 주발		(mainFoot - String)
// 팀		(team - String)
// 골		(goal - int)
// 어시스트	(assist - int)
// 경고수 	(foul - int)

// 잠자기 	    (sleep) - 작업 : "(취침시간) ~ (기상시간까지) 취침" 출력
// 밥먹기 	    (eat) - 작업 : "(음식) 먹음" 출력
// 훈련하기 	    (train) - 작업 : "훈련!!" 출력
// 경기결과내기(성과)	(setGameResult) - 작업 : 골, 어시스트, 경고수 속성 변경
// 이적하기		(moveTeam) - 작업 : 팀 변경

class FootballPlayerA {
	String name;
	String position;
	String birth;
	double height;
	double weight;
	String country;
	String mainFoot;
	String team;
	int goal;
	int assist;
	int foul;
	
	void sleep (String bedtime, String wakeUpTime) {
		System.out.println(bedtime + " ~ " + wakeUpTime + "까지 취침");
	}
	
	void eat (String food) {
		System.out.println(food + " 먹음");
	}
	
	void train () {
		System.out.println("훈련!!");
	}
	
	void setGameResult (int goalResult, int assistResult, int foulResult) {
		goal += goalResult;
		assist += assistResult;
		foul += foulResult;
	}
	
	void moveTeam (String destinationTeam) {
		team = destinationTeam;
	}
	
	void printInformation () {
		System.out.println("==============");
		System.out.println(name + "의 정보");
		System.out.println("포지션 : " + position);
		System.out.println("생년월일 : " + birth);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("국적 : " + country);
		System.out.println("주발 : " + mainFoot);
		System.out.println("소속팀 : " + team);
		System.out.println("득점 : " + goal);
		System.out.println("어시스트 : " + assist);
		System.out.println("파울 : " + foul);
		System.out.println("==============");
	}
}



public class A_ClassAndObject {
	
	// 전역 필드(변수)
	// String team;

	public static void main(String[] args) {
		
		// 지역변수
		// String team;
		
		// 인스턴스: 특정 클래스로 정의된 것을 실체화한 것 (객체)
		// 구조
		// 클래스명 참조변수명 = new 클래스명();
		ExampleClass1 instance1 = new ExampleClass1();
		ExampleClass1 instance2 = new ExampleClass1();
//		ExampleClass1 instance1 = new ExampleClass1(0, 0); // 매개변수를 넣지 않았기 때문에 에러 발생
//		ExampleClass1 instance2 = new ExampleClass1(0, 0); // 자동완성 생성자가 있어서 작동할 수 없음
		
		System.out.println(instance1);
		System.out.println(instance2);
		
		// 인스턴스가 가지고 있는 속성 접근 방법
		// 인스턴스.속성명;
		instance1.attribute1 = 10;
		instance1.attribute2 = 3.14;
		System.out.println(instance1.attribute1);
		System.out.println(instance1.attribute2);
		System.out.println(instance2.attribute1);
		System.out.println(instance2.attribute2);
		
		// 인스턴스가 가지고 있는 메서드 호출 방법
		// 인스턴스.메서드();
		
		// 매개변수 값이 바로 선언부에 들어가는 것이 아니라 복사되어 입력됨
		instance1.method1(1, 2); // 매개변수가 없으면 컴파일 에러
		instance1.method2();
		instance1.method3(1); // 매개변수가 없으면 컴파일 에러
		instance1.method4();
		
		
		
		FootballPlayerA son = new FootballPlayerA();
		FootballPlayerA lee = new FootballPlayerA();
		
		son.name = "손흥민";
		son.position = "공격수";
		son.birth = "920708";
		son.height = 183.0;
		son.weight = 77.0;
		son.country = "대한민국";
		son.mainFoot = "오른발";
		son.team = "토트넘 홋스퍼 FC";
		son.goal = 0;
		son.assist = 0;
		son.foul = 0;
		
		lee.name = "이강인";
		lee.position = "미드필더";
		lee.birth = "010219";
		lee.height = 174.0;
		lee.weight = 71.0;
		lee.country = "대한민국";
		lee.mainFoot = "왼발";
		lee.team = "파리 생제르맹 FC";
		lee.goal = 0;
		lee.assist = 0;
		lee.foul = 0;
		
		System.out.println(lee.name);
		
		son.sleep("21:00", "06:00");
		son.eat("컵라면");
		son.train();
		son.setGameResult(1, 1, 0);
		son.moveTeam("아스날 FC");
		
		System.out.println(son.name + "의 정보");
		System.out.println("포지션 : " + son.position);
		System.out.println("생년월일 : " + son.birth);
		System.out.println("키 : " + son.height);
		System.out.println("몸무게 : " + son.weight);
		System.out.println("국적 : " + son.country);
		System.out.println("주발 : " + son.mainFoot);
		System.out.println("소속팀 : " + son.team);
		System.out.println("득점 : " + son.goal);
		System.out.println("어시스트 : " + son.assist);
		System.out.println("파울 : " + son.foul);
		
		
		lee.setGameResult(0, 1, 2);
		
		System.out.println(lee.name + "의 정보");
		System.out.println("포지션 : " + lee.position);
		System.out.println("생년월일 : " + lee.birth);
		System.out.println("키 : " + lee.height);
		System.out.println("몸무게 : " + lee.weight);
		System.out.println("국적 : " + lee.country);
		System.out.println("주발 : " + lee.mainFoot);
		System.out.println("소속팀 : " + lee.team);
		System.out.println("득점 : " + lee.goal);
		System.out.println("어시스트 : " + lee.assist);
		System.out.println("파울 : " + lee.foul);
		
		lee.moveTeam("수원 삼성");
		lee.printInformation();
		
		son.printInformation();
		
		// static 변수는 클래스로 직접 접근이 가능
		// 인스턴스가 ExampleClass1과 다름 없기 때문
		ExampleClass1.staticAttribute = 99;
		// instance 변수와 메서드는 '반드시' 인스턴스를 생성하여 인스턴스로 접근 및 호출
//		ExampleClass1.attribute1 = 10;
//		ExampleClass1.method1(0, 0);
		instance1.staticAttribute = 99;
		System.out.println(instance1.staticAttribute);
		System.out.println(instance2.staticAttribute);
		// staticAttribute에 한 번 99를 할당했기 때문에 instance2에도 99가 뜨는 것
		// static 변수는 클래스를 불러올 시점에 한 번만 메모리에 할당 되기 때문에 동일하게 99가 출력됨
		// 값이 고정된다고 생각하면 쉬울 듯
		
		ExampleClass1.staticMethod();
		instance1.staticMethod();
		instance2.staticMethod();
		
		ExampleClass1 instance3 = new ExampleClass1();
//		ExampleClass1 instance3 = new ExampleClass1(99, -99.99); // 생성자로 만들었을 경우
		System.out.println(instance3.attribute1);
		System.out.println(instance3.attribute2);
		
		ExampleClass1 instance4 = new ExampleClass1();
//		ExampleClass1 instance4 = new ExampleClass1(999, 99.99);
		// 생성자로 만들었을 경우 attribute1과 attribute2는 이미 의존된 값이기 때문에 다른 값을 출력하기 위해서는 재할당해야 함
		System.out.println(instance4.attribute1); // 99
		System.out.println(instance4.attribute2); // -99.99
//		instance4.attribute1 = 999; // 생성자로 만들어서 매개변수에 값을 입력했으므로 이 과정은 필요 없음
//		instance4.attribute2 = 99.99;
		
		ExampleClass1 instance5 = new ExampleClass1();
		System.out.println(instance5.attribute1);
		System.out.println(instance5.attribute2);
		ExampleClass1 instance6 = new ExampleClass1(100);
		System.out.println(instance6.attribute1);
		System.out.println(instance6.attribute2);

	}

}
