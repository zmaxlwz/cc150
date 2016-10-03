package prob3;

//5.3 Given a positive integer, print the next smallest and the next largest number 
//that have the same number of 1 bits in their binary representation.

public class Solution {
	
	public int nextSmallest(int n){
		//smallest: should be negative, the first bit is 1, 
		//all other 1s are to the right-most 
		
		int countOnes = 0;
		while(n>0){
			if( (n&1) > 0){
				countOnes++;
			}
			n = n>>1;
		}
		
		int countZeroes = 32 - countOnes;
		int num = 0;
		for(int i=0;i<countZeroes;i++){
			num = (num<<1)+1;
		}
		return (~(num << (countOnes-1))) & (-1);
		
	}
	
	public int nextLargest(int n){
		//largest: should be positive, the first bit is 0, 
		//all other 1s are to the left-most, except the first bit
		
		int countOnes = 0;
		while(n>0){
			if( (n&1) > 0){
				countOnes++;
			}
			n = n>>1;
		}
		
		int num = 0;
		for(int i=0;i<countOnes;i++){
			num = (num<<1)+1;
		}
		
		num = num << (31 - countOnes);
		
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
