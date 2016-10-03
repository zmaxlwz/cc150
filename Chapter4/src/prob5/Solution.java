package prob5;


//4.5 Implement a function to check if a binary tree is a binary search tree.

public class Solution {
	
	//give each sub-tree a range, if a node value lies out of this range, return false, it is not a BST
	//can do it recursively: if the root lies in the range and both left and right subtrees are BST and in their own range, return true 
	//or iteratively: use a queue, enqueue each node with their range, when dequeue, check if the node value is in the range

	
	public boolean isBST(TreeNode root){
		
		if(root == null){
			return true;
		}
				
		return checkBSTRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean checkBSTRange(TreeNode root, int min, int max){
		
		if(root == null){
			return true;
		}
		
		if(root.data <= min || root.data > max){
			return false;
		}
		
		return checkBSTRange(root.left, min, root.data) && checkBSTRange(root.right, root.data, max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode{
	int data;
	TreeNode left, right;
	TreeNode(int d){
		this.data = d;
		this.left = null;
		this.right = null;
	}
	
}
