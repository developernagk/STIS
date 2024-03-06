package trainnig;
// https://school.programmers.co.kr/learn/courses/30/lessons/181949
import java.util.Scanner;

public class Print04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String result = "";
        char ch = ' ';
		
        for(int i = 0; i < a.length(); i++) {
            ch = a.charAt(i);
            if(Character.isUpperCase(ch)) {
                result += Character.toLowerCase(ch);
            } else {
                result += Character.toUpperCase(ch);
            }
        }
        System.out.println(result);

        sc.close();

	}

}
