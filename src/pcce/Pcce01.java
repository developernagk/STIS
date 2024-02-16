package pcce;
// https://school.programmers.co.kr/learn/courses/30/lessons/250133
import java.util.Scanner;

public class Pcce01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 함수 중복 불가능!! nextLine이 2번 쓰일 수 없음
		String msg = sc.nextLine();
		int val1 = sc.nextInt();
		String val2 = sc.next();
		
		System.out.println(msg);
		System.out.println(val1 + 10);
		System.out.println(val2 + "10");
		
		sc.close();

	}

}