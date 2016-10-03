package prob8;


//4.8 You have two very large binary trees: 
//		T1, with millions of nodes, and T2, with hundreds of nodes. 
//Create an algorithm to decide if T2 is a subtree of T1.
//A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. 
//That is, if you cut off the tree at node n, the two trees would be identical.

public class Solution {

	
	public boolean isIdentical(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null){
			return true;
		}
		
		if(root1 == null || root2 == null){
			return false;
		}
		
		if(root1.data != root2.data){
			return false;
		}
		
		return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
		
	}
	
	public boolean isSubtree(TreeNode T1, TreeNode T2){
		//use recursion, check if T2 is a subtree of T1, 
		//first check if T2 is identical to the root tree, 
		//if not, check if T2 is a subtree of T1's left tree, or a subtree of T1's right tree
		
		if(T2 == null){
			return true;
		}
		
		if(T1 == null){
			return false;
		}
		
		if(T1.data == T2.data && isIdentical(T1, T2)){
			return true;
		}
		
		return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
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

