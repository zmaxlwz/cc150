package prob4;

import java.util.ArrayList;


//2.4 Write code to partition a linked list around a value x, 
//such that all nodes less than x come before all nodes greater than or equal to x.

public class Solution {
	
	public Node partitionLinkedList(Node head, int x){
		//scan the linked list, if a node value is less than x, remove it and add it to a new list, otherwise, skip it
		//after the first step, we have two lists, the first one includes nodes greater than or equal to x, 
		//the second one includes nodes less than x
		//append the first list to the end of the second one
		
		Node head1 = new Node(0);
		head1.next = head;
		
		Node head2 = new Node(0);
		
		Node p1 = head1, p2 = head2;
		
		int element;
		while(p1.next != null){
			element = p1.next.data;
			if(element < x){
				//this node is less than x, remove it and add to second list
				p2.next = p1.next;
				p2 = p2.next;
				p1.next = p1.next.next;
			}
			else{
				p1 = p1.next;
			}
		}
		
		p2.next = head1.next;
		
		return head2.next;
	}
	
	public void printLinkedList(Node head){
		Node p = head;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(p!=null){
			list.add(p.data);
			p = p.next;
		}
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		Node head = new Node(9);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(7);
		
		sol.printLinkedList(head);
		
		int x = 5;
		head = sol.partitionLinkedList(head, x);
		
		sol.printLinkedList(head);
		

	}

}

class Node{
	int data;
	Node next;
	Node(int d){
		this.data = d;
		this.next = null;
	}
}

