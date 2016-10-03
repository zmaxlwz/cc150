package prob2;


//2.2 Implement an algorithm to find the kth to last element of a singly linked list.

public class Solution {
	
	public int findKthToLast(Node head, int k){
		//use two scans, 
		//the first scan find the number of nodes
		//the second scan find the element
		
		int count = 0;
		Node p = head;
		while(p!=null){
			count++;
			p = p.next;
		}
		
		int index = count+1-k;
		
		count = 0;
		p = head;
		int result = 0;
		while(p!=null){
			count++;
			if(count == index){
				result = p.data;
			}
			p = p.next;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		int k = 4;
		System.out.println(sol.findKthToLast(head, k));
		
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