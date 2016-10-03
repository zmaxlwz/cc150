package prob3;

//3.3 Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
//Therefore, in real life, we would likely start a new stack when the previous stack
//exceeds some threshold. Implement a data structure SetOfStacks that mimics
//this. SetOfStacks should be composed of several stacks and should create a
//new stack once the previous one exceeds capacity. SetOfStacks.push() and
//SetOfStacks.pop() should behave identically to a single stack (that is, pop()
//should return the same values as it would if there were just a single stack).

import java.util.*;

public class SetOfStacks {
	//use an ArrayList of LinkedList
	//each LinkedList is a stack
	//push: if the last LinkedList is not full(not reach the max size), push to the last LinkedList, 
	//			otherwise, insert a new LinkedList and push to the new LinkedList
	//pop: if the last LinkedList is not empty, pop from the last LinkedList, 
	//		if the last LinkedList is empty, remove the last LinkedList, and pop from the new last LinkedList

	ArrayList<LinkedList<Integer>> setOfStacks;
	int maxSizeThreshold;
	
	public SetOfStacks(int threshold){
		//initialize the set of stacks
		this.setOfStacks = new ArrayList<LinkedList<Integer>>();
		//insert the first stack
		this.setOfStacks.add(new LinkedList<Integer>());
		//set threshold
		this.maxSizeThreshold = threshold;
	}
	
	public void push(int n){
		int numStacks = this.setOfStacks.size();
		LinkedList<Integer> stack = this.setOfStacks.get(numStacks-1);
		if(stack.size()<this.maxSizeThreshold){
			//not reach the max threshold
			stack.push(n);
		}
		else{
			//the last stack reaches max threshold, add a new stack
			this.setOfStacks.add(new LinkedList<Integer>());
			this.setOfStacks.get(numStacks).push(n);
		}
	}
	
	public int pop(){
		int numStacks = this.setOfStacks.size();
		LinkedList<Integer> stack = this.setOfStacks.get(numStacks-1);
		if(!stack.isEmpty()){
			return stack.pop();
		}
		else{
			if(numStacks == 1){
				throw new NoSuchElementException();
			}
			else{
				//remove the last empty stack
				this.setOfStacks.remove(numStacks-1);
				stack = this.setOfStacks.get(numStacks-2);
				return stack.pop();
			}
		}
		
	}
	
	public int popAt(int index){
		//pop from the corresponding sub-stack
		int numStacks = this.setOfStacks.size();
		
		if(index >= numStacks){
			throw new NoSuchElementException();
		}
		
		LinkedList<Integer> stack = this.setOfStacks.get(index);
		if(stack.isEmpty()){
			throw new NoSuchElementException();
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int threshold = 2;
		SetOfStacks setOfStacks = new SetOfStacks(threshold);
		
		setOfStacks.push(1);
		setOfStacks.push(2);
		setOfStacks.push(3);
		
		System.out.println(setOfStacks.popAt(0));
		System.out.println(setOfStacks.pop());
		System.out.println(setOfStacks.pop());

	}

}
