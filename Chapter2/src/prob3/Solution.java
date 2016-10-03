package prob3;

import java.util.ArrayList;


//2.3 Implement an algorithm to delete a node in the middle of a singly linked list,
//given only access to that node.
//EXAMPLE
//Input: the node c from the linked list a->b->c->d->e
//Result: nothing is returned, but the new linked list looks like a- >b- >d->e


public class Solution {
	
	public void deleteNodeInMiddle(Node head, Node node){
		//delete the given node from the list
		//as the node is in the middle, there is at least one node after it
		//we copy the element in the node after to this node, 
		//and delete the node after
		
		node.data = node.next.data;
		node.next = node.next.next;
		
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
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		
		sol.printLinkedList(head);
		
		sol.deleteNodeInMiddle(head, head.next.next);
		
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
