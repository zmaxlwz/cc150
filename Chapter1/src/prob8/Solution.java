package prob8;

//1.8 Assume you have a method isSubstring which checks if one word is a substring of another. 
//Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring 
//(e.g.,"waterbottle"is a rotation of"erbottlewat").


public class Solution {
	
	public boolean isRotation(String s1, String s2){
		//check if s1 is a rotation of s2
		//use only one isSubstring method call
		//check if s2 is a substring of s1+s1
		
		if(s1 == null || s1.length() == 0){
			return (s2 == null || s2.length() == 0);
		}
		
		if(s2 == null || s2.length() == 0){
			return (s1 == null || s1.length() == 0);
		}
		
		if(s1.length() != s2.length()){
			return false;
		} 
		
		String s = s1 + s1;
		if(s.indexOf(s2) == -1){
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		
		System.out.println(sol.isRotation(s1, s2));
		

	}

}
