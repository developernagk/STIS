package pcce;
// https://school.programmers.co.kr/learn/courses/30/lessons/250132
import java.util.Scanner;

public class Pcce02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = (int) (Math.pow(c, 2) - Math.pow(a, 2));
        // int b_square = c**2 - a**2;
        // 아래 코드는 수정 전 코드
        // int b_square = c - a;

        System.out.println(b_square);
        
        sc.close();

	}

}