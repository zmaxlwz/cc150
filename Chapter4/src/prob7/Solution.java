package prob7;


//4.7 Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
//Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.

public class Solution {
	
	
	public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
		
		//need to search the tree
		//sol 1: if the root == p or q or null, return root, 
		//	       otherwise, if neither the left tree nor the right tree returns null, return root, 
		//	       if the left tree doesn't return null, return left result 
		//	       if the right tree doesn't return null, return the right result
		//			if both left and right tree returns null, return null

		
		if(root == null || root == p || root == q){
			return root;
		}
		
		TreeNode leftNode = findLCA(root.left, p, q);
		TreeNode rightNode = findLCA(root.right, p, q);
		
		if(leftNode != null && rightNode != null){
			return root;
		}
		else if(leftNode != null){
			return leftNode;
		}
		else if(rightNode != null){
			return rightNode;
		}
		else{
			return null;
		}
				
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
