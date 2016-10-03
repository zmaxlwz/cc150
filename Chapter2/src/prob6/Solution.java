package prob6;


//2.6 Given a circular linked list, implement an algorithm 
//which returns the node at the beginning of the loop.

public class Solution {
	
	public Node findStartCircularList(Node head){
		//use a slow pointer and a fast pointer
		//when they meet, move one of the pointer to the head
		//the next time they will meet at the start of the circle
		
		Node p1 = head, p2 = head;
		
		p1 = p1.next;
		p2 = p2.next.next;
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		p1 = head;
		
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = head.next.next;
		
		Node circleStartNode = sol.findStartCircularList(head);
		
		System.out.println(circleStartNode.data);

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

