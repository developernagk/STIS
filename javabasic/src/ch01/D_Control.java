package ch01;

import java.util.Scanner;

public class D_Control {

	public static void main(String[] args) {
		
		// 제어문: 조건에 따라서 코드의 흐름을 결정하는 것
		
		Scanner scanner = new Scanner(System.in);
		
		// 조건문: 특정 조건이 만족하면 코드를 실행하는 것, 만족하지 않으면 실행하지 않음
		
		// if: 주어진 조건이 true이면 코드를 실행하도록 하는 것
		// if (조건-논리표현식) { 실행할 코드 }
		int age = 18;
		
		// age는 17보다 크거나 같으면서 19보다 작거나 같아야한다.
		// age >= 17 && age <= 19
		
		// age는 17보다 크거나 같거나 19보다 작거나 같아야 한다.
		// age >= 17 || age <= 19
		
		// 부정연산자: 논리 표현식을 부정하는 연산
		// !논리 : true면 false. false면 true를 반환
		boolean isHighSchool = age >= 17 && age <= 19; // 연산의 부정 age < 17 || age > 19
		if (!isHighSchool) {
			System.out.println("고등학생이 아닙니다.");
		}
		
		System.out.println("프로그램 종료");
		
		System.out.println("=====================================");
		System.out.println("=====================================");
		
		// else: if 문의 조건-논리표현식이 false면 코드를 실행하도록 하는 것
		// if (조건-논리표현식) { true이면 실행할 코드 }
		// else { false이면 실행할 코드 }
		
		// 1. else 문은 반드시 if 문 이후에 와야함(else 단독으로 사용이 불가능)
		// 2. else 문에는 조건을 작성하지 않음
		age = 20;
		// String result = "성인입니다."; 여기서 먼저 변수 선언을 하면 if 문에서는 중복이라고 뜸
		
		// 하나의 구문일 경우 중괄호가 없어도 결과는 똑같이 출력 
		if (age > 19) {
			// String result = "성인입니다.";
			System.out.println("성인입니다.");
		}
		else {
			// String result = "성인입니다.";
			// if 문에서 result를 선언했어도 위치가 다르기 때문에 result가 새로 선언됨(저장된 주소가 다름)
			System.out.println("미성년자입니다.");
		}
		// String result = "성인입니다."; - 여기도 마찬가지, 위에서부터 읽어내리기 때문에 외부에 선언해도 영향이 없음 
		System.out.println("프로그램 종료");
		
		//
		
		String fruit = "수박";
		if (fruit.equals("사과")) {
			
		} else if (fruit.equals("바나나")){
			
		} else if (fruit.equals("귤")) {
			
		} else {
			
		}
		
		// switch: 특정 변수 또는 값에 따라 실행할 코드 블록의 범위를 결정하는 것
//		switch (변수-일반표현식) {
//		case 값1:
//			변수-일반표현식이 값1과 같을 때 시작할 코드 위치
//		case 값2:
//			변수-일반표현식이 값2와 같을 때 시작할 코드 위치
//			switch 내부에서 break 문을 만나면 switch 문을 종료
//			break;
//		case 값3:
//			변수-일반표현식이 값3과 같을 때 시작할 코드 위치
//		default:
//			변수-일반표현식이 case의 값과 일치하는 것이 없거나 바로 위에서 break 문을 만나지 않으면 실행되는 코드
//		}
		
		int input = 5;
		// input이 0이면 ABC를 출력
		// input이 1이면 BC
		// input이 2이면 C
		// input이 3이면 DEF
		// input이 4이면 EF
		// input이 0-4가 아니면 F
		
		switch (input) {
		case 0:
		    System.out.println("A");
		case 1:
		    System.out.println("B");
		case 2:
		    System.out.println("C");
		    break;
		case 3:
		    System.out.println("D");
		case 4:
		    System.out.println("E");
		default:
		    System.out.println("F");
		}
		
		// input이 0이면 A를 출력
		// input이 1이면 B
		// input이 2이면 C
		// input이 3이면 D
		// input이 4이면 E
		// input이 0-4가 아니면 F 
		switch (input) {
		case 0:
		    System.out.println("A");
		    break;
		case 1:
		    System.out.println("B");
		    break;
		case 2:
		    System.out.println("C");
		    break;
		case 3:
		    System.out.println("D");
		    break;
		case 4:
		    System.out.println("E");
		    break;
		default:
		    System.out.println("F");
		}
		System.out.println("=====================================");
		System.out.println("=====================================");
		
		// 반복문: 특정 조건에 부합하면 지정한 코드를 여러 번 실행하도록 하는 것
		
		// for: 일반적 반복 횟수가 정해져있을 때 사용하는 반복문
		// for (조건에사용할변수초기화; 조건; 조건에사용할변수증감) { 반복할코드 }
		
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
//		System.out.println("안녕하세요.");
		// ... * 100
		
		for (int count = 1; count <= 3; count++) {
			// System.out.println(count);
			System.out.println("안녕하세요.");
		}
		
//		System.out.println("1번 안녕하세요.");
//		System.out.println("2번 안녕하세요.");
//		System.out.println("3번 안녕하세요.");
//		System.out.println("4번 안녕하세요.");
//		System.out.println("5번 안녕하세요.");
//		
//		System.out.println("n번 안녕하세요.");
		
		for (int count = 1; count <= 5; count++) {
			System.out.println((3*count-4) + "번 안녕하세요.");
		}
		
		System.out.println("=========================================");
//		System.out.println("2 * 1 = 2");
//		System.out.println("2 * 2 = 4");
//		System.out.println("2 * 3 = 6");
//		System.out.println("2 * 4 = 8");
//		System.out.println("2 * 5 = 10");
//		System.out.println("2 * 6 = 12");
//		System.out.println("2 * 7 = 14");
//		System.out.println("2 * 8 = 16");
//		System.out.println("2 * 9 = 18");
		
//		for (int count = 1; count <= 9; count++) {
//			System.out.println("2 * " + count + " = " + (2*count));
//		}
//		
//		for (int n = 1; n <= 9; n++) {
//			System.out.println("3 * " + n + " = " + (3*n));
//		}
//		
//		for (int n = 1; n <= 9; n++) {
//			System.out.println("4 * " + n + " = " + (4*n));
//		}
//		
//		// ...
//		
//		for (int n = 1; n <= 9; n++) {
//			System.out.println("9 * " + n + " = " + (9*n));
//		}
		
		// 2단부터 9단까지 구구단
//		for (int dan = 2; dan <= 9; dan++) {
//			for(int n = 1; n <= 9; n++) {
//				System.out.println(dan + " * " + n + " = " + (dan * n));
//			}
//		}
		
		int[] numbers = new int[5];
//		numbers[0] = 1;
//		numbers[1] = 2;
//		numbers[2] = 3;
//		numbers[3] = 4;
//		numbers[4] = 5;
		
		for (int index = 0; index < numbers.length; index++) {
			numbers[index] = index + 1;
		}
		
//		System.out.println(numbers[0]);
//		System.out.println(numbers[1]);
//		System.out.println(numbers[2]);
//		System.out.println(numbers[3]);
//		System.out.println(numbers[4]);

//		for (int index = 0; index < numbers.length; index++) {
//			System.out.println(numbers[index]);
//		} // for-each 문 사용 가능
		
		// foreach: 컬렉션(배열)의 각 요소를 하나씩 변수에 '복사'하여 사용하는 반복문
		// numbers : {1, 2, 3, 4, 5}
		for (int number: numbers) {
			System.out.println(number);
		}
		
		System.out.println("---------------------");
		
		for (int number: numbers) {
			number = 0;
		} // 출력 결과 : 1, 2, 3, 4, 5 -> 0인 number 자리에 index가 복사되어 출력됨
		
//		for (int index = 0; index < numbers.length; index++) {
//			numbers[index] = 0;
//		} // 출력 결과 : 전부 0 -> numbers index에 각 자리마다 0이 입력되어 전부 0으로 출력됨
		
		for (int number: numbers) {
			System.out.println(number);
		}
		
		// while: 반복할 횟수가 정해져있지 않을 때 사용하는 반복문, 잘 쓰이지 않음
		// 조건이 true인 동안 반복, 조건이 false가 되면 반복 종료
		input = 1;
		
		while (input != 0) {
			input = scanner.nextInt();
			if (input % 2 != 0) { 
				// continue: 반복문에서 continue 문을 만나면 조건 검사로 넘어감, 반복문 내에서 처음으로 돌아감
				continue;
			}
			if (input == 0) {
				// break: 반복문에서 break 문을 만나면 반복문을 종료, 반복문을 종료하고 마지막으로 넘어감
				break;
			}
			
			System.out.println("입력 값 : " + input);
			System.out.println("while 반복문 실행중...");
		}
		System.out.println("while 반복문 종료!");
		
		
	    // 위의 실행문에 0 넣으면 밑의 for 문 실행
		for (int index = 0; index < 10; index ++) {
			if (index % 3 == 0) continue;
			if (index == 8) break;
			System.out.println(index);
		}
		
	}

}
