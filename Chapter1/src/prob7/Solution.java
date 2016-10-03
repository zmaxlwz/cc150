package prob7;

import java.util.Arrays;


//1.7 Write an algorithm such that if an element in an MxN matrix is 0, 
//its entire row and column are set to 0.

public class Solution {
	
	public void setZeros(int[][] matrix){
		//use the first row to record if any column has zeros and 
		//the first column to record if any row has zeros
		//first need to record if the first row or the first column has any zero
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return;
		}
		
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		
		boolean hasZeroFirstRow = false;
		
		for(int i=0;i<numCols;i++){
			if(matrix[0][i] == 0){
				hasZeroFirstRow = true;
			}
		}
		
		boolean hasZeroFirstCol = false;
		
		for(int i=0;i<numRows;i++){
			if(matrix[i][0] == 0){
				hasZeroFirstCol = true;
			}
		}
		
		//check all elements except first row and first column
		for(int i=1;i<numRows;i++){
			for(int j=1;j<numCols;j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
				
		//set the row to zero
		for(int i=1;i<numRows;i++){
			if(matrix[i][0]==0){
				for(int j=1;j<numCols;j++){
					matrix[i][j] = 0;
				}
			}
		}
		
		//set column to zero
		for(int j=1;j<numCols;j++){
			if(matrix[0][j] == 0){
				for(int i=1;i<numRows;i++){
					matrix[i][j] = 0;
				}
			}
		}
		
		//set first row
		if(hasZeroFirstRow){
			for(int j=0;j<numCols;j++){
				matrix[0][j] = 0;
			}
		}
		
		//set first column
		if(hasZeroFirstCol){
			for(int i=0;i<numRows;i++){
				matrix[i][0] = 0;
			}
		}
		
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		//int[][] matrix = {{1,2}, {3,4}};		
		//int N = 2;
		
		int[][] matrix = {{1,2,0,3}, {4,0,5,6}, {7,8,9,0}, {10,11,12,13}};		
		int N = 4;
		
		for(int i=0; i<N; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		sol.setZeros(matrix);

		System.out.println("After zero set:");
		
		for(int i=0; i<N; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
		

	}

}
