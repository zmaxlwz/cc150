package prob5;

//1.5 Implement a method to perform basic string compression using the counts of repeated characters. 
//For example, the string aabcccccaaa would become a2b1c5a3. 
//If the "compressed" string would not become smaller than the original string, 
//your method should return the original string. 
//You can assume the string has only upper and lower case letters(a-z)

public class Solution {
	
	public String compressString(String s){
		String result = "";
		
		if(s == null || s.length() == 0){
			return result;
		}
		
		int length = s.length();
		
		StringBuffer sb = new StringBuffer();
		char chLast = s.charAt(0);
		int count = 1;
		sb.append(chLast);
		
		char chCurrent;
		for(int i=1;i<length;i++){
			chCurrent = s.charAt(i);
			if(chCurrent == chLast){
				count++;
			}
			else{
				sb.append(count);
				chLast = chCurrent;
				count = 1;
				sb.append(chLast);
			}
		}
		
		sb.append(count);
		
		if(sb.length()<length){
			result = sb.toString();
		}
		else{
			result = s;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//String s = "aabcccccaaa";
		String s = "abc";
		
		s = sol.compressString(s);
		System.out.println(s);

	}

}
