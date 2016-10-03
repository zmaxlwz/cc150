package prob1;

//1.1 Implement an algorithm to determine if a string has all unique characters. 
//		What if you cannot use additional data structures.

import java.util.*;

public class Solution {
	
	public boolean uniqChars(String s){
		//check if the input string s has all unique chars
		//use HashSet
		//run time is O(n)
		
		if(s == null || s.length() == 0){
			return true;
		}
		
		HashSet<Character> set = new HashSet<Character>();
		int length = s.length();
		
		for(int i = 0; i<length; i++){
			char c = s.charAt(i);
			if(set.contains(c)){
				return false;
			}
			else{
				set.add(c);
			}
		}
		
		return true;
	}
	
	public boolean uniqChars2(String s){
		//check if the input string s has all unique chars
		//use two loops
		//run time is O(n^2)
		
		if(s == null || s.length() == 0){
			return true;
		}
		
		int length = s.length();
		
		char c1, c2;
		for(int i = 0; i<length-1;i++){
			c1 = s.charAt(i);
			for(int j=i+1;j<length;j++){
				c2 = s.charAt(j);
				if(c2==c1){
					return false;
				}
			}
		}
		
		return true;				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab c";
		
		Solution sol = new Solution();
		boolean uniqChars = sol.uniqChars2(s);
		System.out.println(uniqChars);

	}

}
