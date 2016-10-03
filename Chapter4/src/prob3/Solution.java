package prob3;


//4.3 Given a sorted (increasing order) array with unique integer elements, 
//write an algorithm to create a binary search tree with minimal height. 


public class Solution {

	public TreeNode buildBST(int[] array){
		//use recursion, 
		//the input to sub-method includes an array and the range for the array, build sub-tree based on the range
		//use the middle element as the root, and recursively create left and right sub-tree according to the left and right part of the array range
		
		if(array == null || array.length == 0){
			return null;
		}
		
		int length = array.length;
		
		return build(array, 0, length-1);
	}
	
	public TreeNode build(int[] array, int startIndex, int endIndex){
		
		if(startIndex>endIndex){
			return null;
		}
		
		int middleIndex = (startIndex + endIndex)/2;
		
		TreeNode node = new TreeNode(array[middleIndex]);
		
		node.left = build(array, startIndex, middleIndex-1);
		node.right = build(array, middleIndex+1, endIndex);
		
		return node;
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