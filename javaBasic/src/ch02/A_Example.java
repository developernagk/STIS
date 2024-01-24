package ch02;

import java.util.Arrays;

// GalaxyPhone

// 제조사 : (maker - String)
// 모델명 : (modelName - String)
// 소유자 : (owner - String)
// 전화번호 : (telNumber - String)
// 전원상태 : (power - boolean)

// 문서화 작업이 중요함!!(유지, 보수 측면에서)
// 전원버튼누름: onPoewr - poewr 상태를 부정
// 전화걸기: call - power가 true일 때 "(상대 전화번호)로 전화를 겁니다." 출력
// 긴급전화걸기: emergency - "112로 전화를 겁니다." 출력
// 휴대전화정보보기: getInformation - power가 true일 때
//
// ==== (전화번호) ====
// 제조사: (제조사)
// 모델명: (모델명)
// 소유자: (소유자)
//
// 출력

class GalaxyPhone {
	static String maker; // 스테틱 변수
	String modelName;
	String owner;
	String telNumber;
	boolean power;
	
	void onPower() {
		power = !power;
	}
	
	void call(String toTelNumber) {
		// power == true 라고 적어줘도 되지만 power 자체에 true, false가 있기 때문에 굳이 적어둘 필요가 없음
		// false를 표현하고 싶으면 power == false로 적는 것보다 !false가 좋음
		if (!power) return; { 
			System.out.println(toTelNumber + "로 전화를 겁니다.");
		}
	}
	
	static void emergency() { // 스테틱 메서드
		System.out.println("112로 전화를 겁니다.");
	}
	
	void getInformation() {
		if (!power) return; {
			System.out.println();
			System.out.println("==== " + telNumber +" ====");
			System.out.println("제조사 : " + maker);
			System.out.println("모델명 : " + modelName);
			System.out.println("소유자 : " + owner);
			System.out.println();
		}
		
	}
	
}



// Drama
// 방송사: (broadcastingCompany - String)
// 제목: (title - String)
// 배우: (actors - String[])
// 장르: (genre - String)
// 시청률: (viewerRating - double)
// 부작: (series - int)

// 정보보기: getInformation
// ==== (title) ====
// 방송사 : (broadcastingCompany)
// 장르 : (genre)
// 부작 : (series)부작
// 시청률 : (viewerRating)%
// 배우 : (actor), (actor), (actor)...		전지현, 김수현, 박해진, 유인나

class Drama {
	String broadcastingCompany;
	String title;
	String[] actors;
	String genre;
	double viewerRating;
	int series;
	
	void getInformation() {
		System.out.println("");
		System.out.println("==== " + title +" ====");
		System.out.println("방송사 : " + broadcastingCompany);
		System.out.println("장르 : " + genre);
		System.out.println("부작 : " + series + "부작");
		System.out.println("시청률 : " + viewerRating + "%");
		System.out.print("배우 : "); // 배열에 접근하기 위함
		// foreach는 사용하지 않는 것이 좋음 foreach는 인덱스에서 꺼내오는 것이 아니라 바로 읽어오기 때문
		for (int index = 0; index < actors.length; index++) {
			System.out.print(actors[index]);
			// {"A", "B", "C"}
			if (index < actors.length - 1) System.out.print(", ");
		}
		// 위의 반복문과 같은 역할
		// index < actors.length - 1 / true : actors[index] + ", " / false : actors[index]
		// System.out.print(index < actors.length - 1 ? actors[index] + ", " : actors[index]);
		// String actor = index < actors.length - 1 ? actors[index] + ", " : actors[index]
		// System.out.print(actor);
		
//		System.out.println("배우 : " + Arrays.toString(actors)); // 문자열을 배열에서 불러오기 위한 자바 기능을 import해서 사용
		System.out.println("");
	}
}



// TriangleMath

// 빗변 구하기 - getHypotenuse
// 둘레 구하기 - getCircumference
// sin 구하기 - getSin
// cos 구하기 - getCos
// tan 구하기 - getTan

class TriangleMath {
	// static 선언으로 의존성 역전 원칙(D)을 설명
//	static final double PI = 3.14; // 단일 책임 원칙(S)
	
	static double getHypotenuse (int bottom, int height) {
		if (bottom <= 0 || height <=0) return 0;
//		if (!(bottom > 0 && height > 0)) return 0; // 위의 OR 연산자와 같은 기능
		
		double result = Math.pow(bottom, 2) + Math.pow(height, 2); // Math.pow(): 제곱하는 기능
		return Math.sqrt(result); // Math.sqrt(): 제곱근 구하는 기능
	}
	
	static double getCircumference (int height, int bottom, int hypotenuse) {
		if (bottom <= 0 || height <= 0 || hypotenuse <= 0) return 0;
		return height + bottom + hypotenuse;
	}
	
	static double getSin (int height, int hypotenuse) {
		if (height <= 0 || hypotenuse <= 0) return 0;
		return height / hypotenuse;
	}
	
	static double getCos (int bottom, int hypotenuse) {
		if (bottom <= 0 || hypotenuse <= 0) return 0;
		return bottom / hypotenuse;
	}
	
	static double getTan (int height, int bottom) {
		if (bottom <= 0 || height <= 0) return 0;
		return height / bottom;
	}
}



public class A_Example {

	public static void main(String[] args) {
		
//		new GalaxyPhone(); // 인스턴스 생성
		GalaxyPhone s23 = new GalaxyPhone();
		// 인스턴스 변수는 GalaxyPhone이지만 참조변수인 s23에 할당해서 s23이 인스턴스 변수로 사용됨
		GalaxyPhone s24 = new GalaxyPhone();
		
		GalaxyPhone.maker = "LG";
		
//		s23.maker = "SAMSUNG";
		s23.modelName = "s23";
		s23.owner = "홍길동";
		s23.telNumber = "010-1234-5678";
		s23.power = false;
		
//		s24.maker = "SAMSUNG";
		s24.modelName = "s24";
		s24.owner = "김철수";
		s24.telNumber = "010-5678-1234";
		s24.power = false;
		
		s23.onPower();
		s23.getInformation();
		
		GalaxyPhone.emergency();
		s23.emergency();
		s24.emergency();
		
		

		Drama star = new Drama(); // 좌항은 참조변수, 우항이 인스턴스 생성

		star.broadcastingCompany = "SBS";
		star.title = "별에서 온 그대";
		star.actors = new String[] {"전지현", "김수현", "박해진", "유인나"}; // new String[]은 잘 쓰지 않음
		star.genre = "로맨스";
		star.viewerRating = 28.1;
		star.series = 21;

		star.getInformation();
		
		// star.series; // 변수는 소괄호가 없음
		// star.getInformation(); // 메서드는 소괄호가 있음
		// 생성자의 이름은 클래스의 이름과 동일
		
		TriangleMath triangleMath = new TriangleMath(); // 위에서 static 선언으로 의존성 역전 원칙(D)을 설명
		
		double bit = TriangleMath.getHypotenuse(3, 4);
		System.out.println(bit);
		
//		System.out.println(TriangleMath.PI); // 단일 책임 원칙(S)
//		TriangleMath.PI = 0.0;
		
	}
}
