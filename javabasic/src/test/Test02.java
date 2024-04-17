package test;

import java.util.Arrays;

class Solution1 {

    public int[] solution(int[] array, int[][] queries) {

        for (int index = 0; index < queries.length; index++) {
            for (int j = queries[index][0]; j <= queries[index][1]; j++) {
                array[j]++;
            }
        }
        return array;
    }
}

public class Test02 {

	public static void main(String[] args) {
		
		System.out.println();

	}

}
