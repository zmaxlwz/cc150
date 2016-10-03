package prob6;

//3.6  Write a program to sort a stack in ascending order (with biggest items on top).
//You may use at most one additional stack to hold items, but you may not copy
//the elements into any other data structure (such as an array). The stack supports
//the following operations: push, pop, peek, and isEmpty.

import java.util.*;

public class Solution {
	
	
	
	Stack<Integer> stack = new Stack<Integer>();
	
	public Stack<Integer> sortStack(Stack<Integer> inputStack){
		int numElements = inputStack.size();
		
		if(numElements <= 1){
			//no need to sort
			return inputStack;
		}
		//push the first element into the temp stack
		stack.push(inputStack.pop());
		for(int i = 0;i<numElements-1;i++){
			int temp = inputStack.pop();
			int count = 0;
			while(!stack.isEmpty() && stack.peek()>temp){
				inputStack.push(stack.pop());
				count++;
			}
			stack.push(temp);
			for(int j=0;j<count;j++){
				stack.push(inputStack.pop());
			}
		}
		
		return stack;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		
		stack = sol.sortStack(stack);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
