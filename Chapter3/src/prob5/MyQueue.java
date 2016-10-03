package prob5;

//3.5 Implement a MyQueue class which implements a queue using two stacks

import java.util.*;

public class MyQueue {
	
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public MyQueue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();		
	}
	
	public void enqueue(int n){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		stack1.push(n);
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
	}
	
	public int dequeue(){
		
		if(stack1.isEmpty()){
			throw new NoSuchElementException();
		}
		
		return stack1.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		queue.enqueue(4);
		System.out.println(queue.dequeue());

	}

}
