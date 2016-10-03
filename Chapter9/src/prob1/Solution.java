package prob1;

//9.1 A child is running up a staircase with n steps, 
//and can hop either 1 step, 2 steps, or 3 steps at a time. 
//Implement a method to count how many possible ways the child can run up the stairs.

public class Solution {
	
	public int numOfWays(int n){
		//use dynamic programming: create an array storing the number of ways to arrive at a particular stair
		//int[] array = int[n+1]
		//array[1] = 1, array[2] = 2, array[3] = 4
		//array[i] = array[i-1] + array[i-2] + array[i-3], for i>3
		
		if(n < 0){
			return 0;
		}
		
		if(n == 0){
			return 1;
		}
		
		int[] array = new int[n+1];
		
		array[1] = 1;
		if(n == 1){
			return array[1];
		}
		
		array[2] = 2;
		if(n == 2){
			return array[2];
		}
		
		array[3] = 4;
		if(n == 3){
			return array[3];
		}
		
		for(int i = 4; i<=n; i++){
			array[i] = array[i-1] + array[i-2] + array[i-3];
		}
		
		return array[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
