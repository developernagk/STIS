package test;

class Solution {
	
    public int solution (int[] numList) {
        for (int index = 0; index < numList.length; index++) {
        	if (numList[index] < 0) {
            	return index;
            }
        }

        return -1;
    }
}

public class Test01 {

	public static void main(String[] args) {
		
		

	}

}
