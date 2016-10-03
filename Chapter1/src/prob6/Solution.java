package prob6;

import java.util.Arrays;

//1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
//write a method to rotate the image by 90 degrees. 
//Can you do this in place?



public class Solution {
	
	public void rotateMatrix(int[][] matrix, int N){
		//each pixel in the image is a 4-byte, we can use an integer to represent it
		//we want to rotate the N*N matrix by 90 degrees by 2 steps:
		//first swap along down diagnal,
		//second swap along middle y-axis
		
		if(N <= 1){
			return;
		}
		
		//swap along down diagnal
		int temp;
		for(int i = 0;i<N-1;i++){
			for(int j=i+1;j<N;j++){
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		//considering the case of N is even or odd
		int y_middle = N/2;
		
		//swap along middle y-axis
		for(int i = 0; i<N; i++){
			for(int j=0;j<y_middle; j++){
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][N-1-j];
				matrix[i][N-1-j] = temp;
			}
		}
		
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		//int[][] matrix = {{1,2}, {3,4}};		
		//int N = 2;
		
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};		
		int N = 3;
		
		
		for(int i=0; i<N; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		sol.rotateMatrix(matrix, N);

		System.out.println("After rotate:");
		
		for(int i=0; i<N; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
		
	}

}
