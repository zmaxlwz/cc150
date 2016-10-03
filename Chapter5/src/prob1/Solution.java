package prob1;

//5.1 You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
//Write a method to insert M into N such that M starts at bit j and ends at bit i. 
//You can assume that the bits j through i have enough space to fit all of M. 
//That is, if M= 10011, you can assume that there are at least 5 bits between j and i. 
//You would not, for example, have j=3 and i=2, because M could not fully fit between bit 3 and bit 2.
//EXAMPLE:
//Input: N = 10000000000, M = 10011, i = 2, j = 6
//Output: N = 10001001100

public class Solution {
	
	public int insert(int N, int M, int i, int j){
		//first clear the bits in N from bit j to bit i
		//then left shift M i bits, and compute M or N
		
		int length = j-i+1;
		int num = 0;
		for(int k=0;k<length;k++){
			num = (num<<1) + 1;
		}
		//clear bit j to bit i
		N = (~(num << i)) & N;
		
		//set bit j to bit i in N to M
		N = N | (M << i);
		
		return N;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		
		int N = 1024;
		int M = 19;
		int i = 2;
		int j = 6;
		
		System.out.println(sol.insert(N, M, i, j));

	}

}
