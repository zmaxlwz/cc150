package prob1;

//2.1 Write code to remove duplicates from an unsorted linked list.
//FOLLOW UP
//How would you solve this problem if a temporary buffer is not allowed?

import java.util.*;

public class Solution {
	
	public Node removeDuplicates(Node head){
		//remove duplicates from the unsorted linked list
		//use a HashSet to record which element has appeared
		//if this element has already appeared, remove it from the list
		
		//create a new null head
		Node newHead = new Node(0);
		newHead.next = head;
		
		Node p = newHead;
		HashSet<Integer> set = new HashSet<Integer>();
		int element;
		while(p.next != null){
			element = p.next.data;
			if(!set.contains(element)){
				set.add(element);
				p = p.next;
			}
			else{
				//remove the next node
				p.next = p.next.next;
			}
		}
		
		return newHead.next;
	}
	
	public Node removeDuplicates2(Node head){
		//don't use additional buffer, 
		//for each element, scan the rest of the list, and remove duplicates if any
		
		if(head == null || head.next == null){
			return head;
		}
		
		Node p = head, q = null;
		int element1, element2;
		while(p.next != null){
			element1 = p.data;
			q = p;
			while(q.next != null){
				element2 = q.next.data;
				if(element2 == element1){
					//remove q.next
					q.next = q.next.next;
				}
				else{
					q = q.next;
				}
			}
			p = p.next;
		}
		
		return head;
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
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(3);
		
		sol.printLinkedList(head);
		System.out.println("print initial done.");
		
		head = sol.removeDuplicates2(head);
		System.out.println("process done.");
		
		sol.printLinkedList(head);
		System.out.println("print final done.");
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