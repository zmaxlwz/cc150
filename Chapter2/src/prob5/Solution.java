package prob5;

import java.util.ArrayList;


//2.5 You have two numbers represented by a linked list, where each node contains a single digit. 
//The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
//Write a function that adds the two numbers and returns the sum as a linked list.

public class Solution {
	
	public Node sumTwoLists(Node head1, Node head2){
		//the two numbers are stored in reverse order
		//use an integer to store the carry
		
		Node p1 = head1, p2 = head2;
		int carry = 0;
		
		Node resultHead = new Node(0);
		Node p = resultHead;
		
		int sum = 0;
		while(p1 != null && p2 != null){
			sum = p1.data+p2.data+carry;
			p.next = new Node(sum%10);
			carry = sum/10;
			p = p.next;
			p1 = p1.next;
			p2 = p2.next;
		}
		
		if(p1 == null && p2 == null){
			if(carry > 0){
				p.next = new Node(carry);
			}
		}
		else if(p1 == null && p2 != null){
			p2.data = p2.data + carry;
			p.next = p2;
		}
		else if(p1 != null && p2 == null){
			p1.data = p1.data + carry;
			p.next = p1;
		}
		
		return resultHead.next;
	}
	
	public Node reverseList(Node head){
		
		if(head == null || head.next == null){
			return head;
		}
		
		Node p1 = head, p2 = head.next;
		Node p3 = null;
		while(p2 != null){
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		
		head.next = null;
		
		return p1;
	}
	
	public Node sumTwoForwardLists(Node head1, Node head2){
		//add two forward linked lists
		//first reverse the two lists, add them using above methods, get a new list
		//then reverse the new list to get forward order form
		
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		
		Node sumHead = sumTwoLists(head1, head2);
		
		sumHead = reverseList(sumHead);
		
		return sumHead;
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
		
		Node head1 = new Node(1);
		head1.next = new Node(6);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(7);
		
		Node head2 = new Node(2);
		head2.next = new Node(9);
		head2.next.next = new Node(5);
		
		//Node head = sol.sumTwoLists(head1, head2);
		Node head = sol.sumTwoForwardLists(head1, head2);
		
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

