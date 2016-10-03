package prob4;


//4.4 Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
//(e.g., if you have a tree with depth D, you'll have D linkedlists). 

import java.util.*;

public class Solution {
	
	
	
	
	public ArrayList<LinkedList<TreeNode>> getLevelList(TreeNode root){
		//use BFS search
		//create an ArrayList of LinkedList, each LinkedList contains the nodes in each level
		
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		
		if(root == null){
			return list;
		}
		
		LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
		LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
		
		queue1.offer(root);
		list.add(new LinkedList<TreeNode>(queue1));
		
		while(!queue1.isEmpty()){
			TreeNode node = queue1.poll();
			if(node.left != null){
				queue2.offer(node.left);
			}
			if(node.right != null){
				queue2.offer(node.right);
			}
			if(queue1.isEmpty()){
				queue1 = queue2;
				queue2 = new LinkedList<TreeNode>();
				if(!queue1.isEmpty()){
					list.add(new LinkedList<TreeNode>(queue1));
				}
			}
		}
		
		return list;
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
