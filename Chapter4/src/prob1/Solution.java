package prob1;

//4.1  Implement a function to check if a binary tree is balanced. 
//For the purposes of this question, a balanced tree is defined to be a tree 
//such that the heights of the two subtrees of any node never differ by more than one. 

public class Solution {
	
	
	public boolean isBalanced(TreeNode root){
		//check if the input binary tree is balanced or not
		
		if(treeHeight(root) == -1){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	public int treeHeight(TreeNode root){
		//return the height of the input binary tree
		
		if(root == null){
			return 0;
		}
		
		int leftTreeHeight = treeHeight(root.left);
		int rightTreeHeight = treeHeight(root.right);
		
		if(leftTreeHeight == -1 || rightTreeHeight == -1){
			return -1;
		}
		
		if(Math.abs(leftTreeHeight-rightTreeHeight) > 1){
			return -1;
		}
				
		return Math.max(leftTreeHeight, rightTreeHeight)+1;
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

