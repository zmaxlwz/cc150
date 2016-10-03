package prob6;


//4.6 Write an algorithm to find the 'next' node (i.e., in-order successor) 
//of a given node in a binary search tree. 
//You may assume that each node has a link to its parent.

public class Solution {

	//there are several cases:
	//1) if the given node has right sub-tree, 
	//		then its next node is the left most node in its right sub-tree 
	//2) if the given node doesn't have right sub-tree, 
	//		then its next node is the first ancestor whose left branch this node lies in, 
	//		follow parent link to find this ancestor
	
	public TreeNode findSmallestLeftChild(TreeNode node){
		
		TreeNode p = node;
		while(p.left != null){
			p = p.left;
		}
		
		return p;
	}
	
	public TreeNode findFirstGreaterAncestor(TreeNode node){
		
		TreeNode q = node;
		TreeNode p = q.parent;
		
		while(p!= null && p.left != q){
			q = p;
			p = q.parent;
		}
		
		if(p == null){
			return null;
		}
		else{
			return p;
		}
		
	}
	
	public TreeNode nextNode(TreeNode inputNode){
		
		if(inputNode.right != null){
			return findSmallestLeftChild(inputNode.right);
		}
		else{
			return findFirstGreaterAncestor(inputNode);			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class TreeNode{
	int data;
	TreeNode left, right, parent;
	TreeNode(int d){
		this.data = d;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
}

