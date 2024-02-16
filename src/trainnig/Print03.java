package trainnig;
// https://school.programmers.co.kr/learn/courses/30/lessons/181950
import java.util.Scanner;

public class Print03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        for (int count = 1; count <= n; count++) {
            System.out.print(str);
        }

	}

}
