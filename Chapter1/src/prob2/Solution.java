package prob2;

//1.2 Implement a function void reverse(char* str) in C or C++ 
//which reverses a null-terminated string.

//here, use JAVA, to implement a function reversing Strings


public class Solution {

	public String reverse(String s){
		//reverse String s, and return it
		
		StringBuffer sb = new StringBuffer();
				
		if(s == null || s.length() == 0){
			return sb.toString();
		}
		
		int length = s.length();
		
		for(int i=length-1;i>=0;i--){
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abc d";
		
		Solution sol = new Solution();
		s = sol.reverse(s);
		
		System.out.println(s);
		System.out.println(s.length());
	}

}
