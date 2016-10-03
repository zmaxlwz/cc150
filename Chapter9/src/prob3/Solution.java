package prob3;

//9.3 A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i. 
//Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.

public class Solution {
	
	public int magicIndex(int[] array){
		//use binary search, first check the middle point, 
		//if A[i] == i, then return i
		//if A[i] > i, then the right side don't have magic index, 
		//			as the integers are distinct and the difference between adjacent integers is at least 1, go to the left side
		//if A[i] < i, then the left side don't have magic index, go to the right side
		//Each time eliminate half of the numbers, run time is O(log(n))
		
		if(array == null || array.length == 0){
			return -1;
		}
		int length = array.length;
		
		return magicIndex(array, 0, length-1);
	}
	
	public int magicIndex(int[] array, int start, int end){
		
		if(end < start){
			//couldn't find the magic index
			return -1;
		}
		
		int middleIndex = (start+end)/2;
		if(array[middleIndex] == middleIndex){
			return middleIndex;
		}
		else if(array[middleIndex] > middleIndex){
			return magicIndex(array, start, middleIndex-1);
		}
		else{
			return magicIndex(array, middleIndex+1, end);
		}
		
	}
	
	public int findMagicIndexFollowUp(int[] array){
		//FOLLOW UP
		//What if the values are not distinct?
		
		//If the values are not distinct, we cannot eliminate half of the numbers, 
		//what we can do is just a linear scan of all the numbers and check if A[i] = i
		
		if(array == null || array.length == 0){
			return -1;
		}
		
		int length = array.length;
		for(int i=0;i<length;i++){
			if(array[i] == i){
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		
		int[] array = {-3, -1, 1, 3, 8, 9};
		
		//System.out.println(sol.magicIndex(array));
		System.out.println(sol.findMagicIndexFollowUp(array));
		

	}

}
