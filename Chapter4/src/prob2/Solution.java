package prob2;

//4.2 Given a directed graph, design an algorithm 
//to find out whether there is a route between two nodes. 

public class Solution {
	//assume the input graph is stored as an adjacency list
	//the graph node has isVisited field
	
	public boolean hasRoute(int startNode, int endNode){
		//use DFS to find the path from the first given node to the second given node, if there is any
		
		return false;
	}
	
	public boolean DFS(int startNode, int endNode){
		
		if(startNode == endNode){
			return true;
		}
		
		//if startNode.next == null, return false
		
		//for neighbor nodes in startNode.next list, DFS(neighbor, endNode)
		//if the DFS call to any neighbor node return true, return true
		
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//build graph


