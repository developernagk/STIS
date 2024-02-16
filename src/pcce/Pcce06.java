package pcce;
// https://school.programmers.co.kr/learn/courses/30/lessons/250128
public class Pcce06 {

	public String[] pcce06 (int[] numbers, int[] our_score, int[] score_list) {
		
        int num_student = numbers.length;
        String[] answer = new String[num_student];

        for (int i = 0; i < num_student; i++) {
        	// numbers가 문자열로 배열이 구성되어있는데
        	// 이것을 인덱스 번호로 호출하면 +1의 자리에 있는 인덱스가 호출되므로 -1을 해줘야 함
        	if (our_score[i] == score_list[numbers[i] - 1]) {
            // 아래 코드가 수정 전 코드
            //if (our_score[i] == score_list[i]) {
                answer[i] = "Same";
            } else {
                answer[i] = "Different";
            }
        }

        return answer;
    }

}
