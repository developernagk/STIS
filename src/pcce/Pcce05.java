package pcce;
// https://school.programmers.co.kr/learn/courses/30/lessons/250129
public class Pcce05 {
	
	public int[] pcce05(String route) {
		int east = 0;
		int north = 0;
		int[] answer = new int[2];
		for (int i = 0; i < route.length(); i++) {
			switch(route.charAt(i)) {
			case 'N':
				north++;
				break;
			case 'S':
				north--;
				break;
			case 'E':
				east++;
				break;
			case 'W':
				east--;
				break;
			}
		}
		answer[0] = east;
		answer[1] = north;
		return answer;
	}
	
}
