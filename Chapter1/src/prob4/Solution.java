package prob4;

//1.4 Write a method to replace all spaces in a string with'%20'.
//input: a String and the real length of the string
//output: replace each space with '%20' in the string


public class Solution {
	
	public String convertString(String s, int length){
		String result = "";
		if(length <=0){
			return result;
		}
		
		int countSpaces = 0;
		char c;
		for(int i = 0;i<length;i++){
			c = s.charAt(i);
			if(c == ' '){
				countSpaces++;
			}
		}
		
		int newLength = length + 2*countSpaces;
		
		char[] newCharArray = new char[newLength];
		int j = newLength-1;
		for(int i=length-1;i>=0;i--){
			c = s.charAt(i);
			if(c != ' '){
				newCharArray[j--] = c;
			}
			else{
				newCharArray[j--] = '0';
				newCharArray[j--] = '2';
				newCharArray[j--] = '%';
			}
		}
		
		result = new String(newCharArray);
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		String s = "Mr John Smith    ";
		int length = 13;
		
		s = sol.convertString(s, length);
		
		System.out.println(s);

	}

}
