package prob2;

//9.2 Imagine a robot sitting on the upper left corner of an X by Y grid. 
//The robot can only move in two directions: right and down. 
//How many possible paths are there for the robot to go from (0, 0) to (X, Y) ?

//FOLLOW UP
//Imagine certain spots are "off limits," such that the robot cannot step on them.
//Design an algorithm to find a path for the robot from the top left to the bottom right.


public class Solution {
	
	public int numOfPaths(int x, int y){
		if(x<0 || y<0){
			return 0;
		}
		if(x == 0 || y == 0){
			return 1;
		}
		
		int[][] array = new int[x+1][y+1];
		for(int i = 0; i<=x; i++){
			array[i][0] = 1;
		}
		
		for(int j=0;j<=y;j++){
			array[0][j] = 1;
		}
		
		for(int i=1;i<=x;i++){
			for(int j=1;j<=y;j++){
				array[i][j] = array[i][j-1] + array[i-1][j];
			}
		}
		
		return array[x][y];
	}
	
	public void findPath(int X, int Y){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
