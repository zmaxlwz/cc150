package prob7;


//2.7 Implement a function to check if a linked list is a palindrome

public class Solution {
	
	public boolean checkPalindrome(Node head){
		//check if the input linked list is a palindrome
		//create a reverse list, scan the two lists and compare if they are the same
		
		if(head == null || head.next == null){
			return true;
		}
		
		Node head2 = new Node(head.data);
		
		Node p = head.next;
		
		while(p != null){
			Node newNode = new Node(p.data);
			newNode.next = head2;
			head2 = newNode;
			p = p.next;
		}
		
		p=head;
		Node q = head2;
		
		while(p != null){
			if(p.data != q.data){
				return false;
			}
			p = p.next;
			q = q.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(5);
		
		System.out.println(sol.checkPalindrome(head));
		
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
