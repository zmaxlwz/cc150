package prob3;

//1.3 Given two strings, 
//write a method to decide if one is a permutation of the other.

import java.util.*;

public class Solution {
	
	public boolean isPermutation(String s1, String s2){
		//check if the two strings are permutation of each other
		//use one HashMap
		//scan the first string to increment count
		//scan the second string to decrement count
		
		if(s1 == null || s1.length() == 0){
			return (s2 == null || s2.length() == 0);
		}
		
		if(s2 == null || s2.length() == 0){
			return (s1 == null || s1.length() == 0);
		}
		
		int length1 = s1.length();
		int length2 = s2.length();
		
		if(length1 != length2){
			return false;
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		char c;
		for(int i=0;i<length1;i++){
			c = s1.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, 1);
			}
			else{
				map.put(c, map.get(c)+1);
			}
		}
		
		for(int i=0;i<length2;i++){
			c = s2.charAt(i);
			if(!map.containsKey(c)){
				return false;
			}
			else if(map.get(c)<=0){
				return false;
			}
			else{
				map.put(c, map.get(c)-1);
			}
		}
		
		int count = 0;
		for(Character ch: map.keySet()){
			count = map.get(ch);
			if(count != 0){
				return false;
			}
		}
		
		return true;
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		
		//String s1 = "abc cb";
		//String s2 = "b cbca";
		String s1 = "ab c";
		String s2 = "cba";
		
		
		boolean isPermuteString = sol.isPermutation(s1, s2);
		System.out.println(isPermuteString);

	}

}
