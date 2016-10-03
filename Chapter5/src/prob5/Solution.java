package prob5;

//5.5 Write a function to determine the number of bits you would 
//need to flip to convert integer A to integer B.

public class Solution {
	
	public int numFlips(int A, int B){
		//first xor the two numbers, 
		//then check how many 1s are there in the result
		
		int result = A ^ B;
		
		int numOnes = 0;
		while(result != 0){
			if((result & 1) > 0){
				numOnes++;
			}
			result = result >>> 1;
		}
		
		return numOnes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		int A = 29;
		int B = 15;
		
		int numFlips = sol.numFlips(A, B);
		
		System.out.println(numFlips);

	}

}
