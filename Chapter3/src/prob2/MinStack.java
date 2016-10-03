package prob2;

//3.2 How would you design a stack which, in addition to push and pop, 
//also has a function min which returns the minimum element? 
//Push, pop and min should all operate in O(1) time.

import java.util.*;

public class MinStack {
	//the top element in the stack also records the min of the stack, 
	//when a new element is pushed, the min is updated and stored in the pushed element
	//when an element is poped, the left top element still has the min for the rest of the stack

	LinkedList<Node> stack;
	
	public MinStack(){
		stack = new LinkedList<Node>();
	}
	
	public void push(int n){
		Node node;
		if(stack.isEmpty()){
			node = new Node(n, n);
		}
		else{
			node = new Node(n, Math.min(n, stack.peek().minNum));
		}
		stack.push(node);
	}
	
	public int pop(){
		if(stack.isEmpty()){
			throw new NoSuchElementException();
		}
		
		Node node = stack.pop();
		
		return node.data;
	}
	
	public int min(){
		if(stack.isEmpty()){
			throw new NoSuchElementException();
		}
		
		Node node = stack.peek();
		
		return node.minNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinStack stack = new MinStack();
		
		//stack.pop();
		
		stack.push(4);
		stack.push(8);
		stack.push(2);
		
		System.out.println(stack.min());
		
		stack.pop();
		
		System.out.println(stack.min());

	}

}

class Node{
	int data;
	int minNum;
	Node(int d, int min){
		this.data = d;
		this.minNum = min;
	}
	
}
