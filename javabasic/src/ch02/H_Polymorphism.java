package ch02;

// 다형성: 하나의 표현이 여러 가지 형태로 나타낼 수 있는 것

// 오버로드: 같은 클래스 내에서 동일한 메서드의 이름으로 여러 개의 메서드를 정의할 수 있도록 하는 것
// 오버라이드: 자손 클래스에서 조상 클래스에 정의된 메서드를 재정의 하는 것

class Human1 {
	String name;
	int age;
}

class Developer1 extends Human1 {
	String position;
}

class FootballPlayer1 extends Human1 implements FootballPlay {
	int goal;

	@Override
	public void kick() {
		
	}
}

interface FootballPlay {
	public abstract void kick ();
}

public class H_Polymorphism {

	public static void main(String[] args) {
		
		Human1 human1 = new Human1();
		
		Developer1 developer1 = new Developer1();
		FootballPlayer1 footballplayer1 = new FootballPlayer1();
		
		// 업캐스팅: 하위클래스의 객체를 상위클래스의 참조 변수에 담을 수 있도록 변환하는 것
		//        인터페이스 구현 클래스를 구현한 인터페이스 타입 참조 변수로 담을 수 있도록 하는 것
		// 가장 많이 사용
		Human1 human2 = new Developer1();
		Human1 human3 = new FootballPlayer1();
		
		// FootballPlay는 인터페이스, 인터페이스는 참조 타입이기 때문에 아래의 식이 가능한 것
		// implements는 구현하기 위한 키워드
		// 아래 코드를 풀어서 설명하면 FootballPlay에 있는 것이 FootballPlayer1에 있는지 확인 후 참조 변수에 담음
		FootballPlay football = new FootballPlayer1();
		
		// human2에는 Human1에 있는 것만 볼 수 있기 때문에 developer1에 있는 position을 보지 못함 
//		human2.position = "";
		
		
		// 다운캐스팅: 업캐스팅 된 객체를 다시 원래의 타입의 참조 변수에 담을 수 있도록 변환하는 것
//		Developer1 developer2 = (Developer1) human2 ;
//		developer2.position = "";
		
		// Object 클래스의 참조변수는 어떠한 클래스의 인스턴스도 받을 수 있음
		Object object1 = new Human1();
		Object object2 = new Developer1();
		Object object3 = new FootballPlayer1();
		
		FootballPlayer1 fp = new FootballPlayer1();
		fp.name = "홍길동";
		fp.age = 30;
		fp.goal = 55;
		
		System.out.println(fp);
		System.out.println(fp.name);
		System.out.println(fp.goal);
		
		Human1 hm = fp;
		System.out.println(hm);
		System.out.println(hm.name);
//		System.out.println(hm.goal);
//		hm.kick(); // 위와 동일하게 다운캐스팅으로 시야가 좁아져서 더이상 쓸 수 없음
		
		FootballPlayer1 fpp = (FootballPlayer1) hm;
		System.out.println(fpp);
		System.out.println(fpp.name);
		System.out.println(fpp.goal);
		
		Human1 hmm = new Human1();
		Developer1 dev = (Developer1) hmm;
		
		dev.position = "포지션";
		System.out.println(dev.position);
		
		
		

	}

}