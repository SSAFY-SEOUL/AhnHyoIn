package day0122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GapMax_10819 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList();
		boolean[] used = new boolean[N];
		
		perm(A, arr, used);
		
		System.out.println(max);
		
	}//main
	
	static int max = 0;

	static void perm(int[] A, ArrayList<Integer> arr, boolean[] used) {
		if(arr.size() == A.length) {
			if(Calc(arr) > max)
				max = Calc(arr);
			
			return;
		}
	
		for(int i = 0; i < A.length; i++) {
			if(!used[i]) { 
				arr.add(A[i]);
				used[i] = true;
				
				perm(A, arr, used);
				
				arr.remove(arr.size()-1);
				used[i] = false;
			}
		}
	}

	static int Calc(ArrayList<Integer> arr) {
		int sum = 0;
		
		for(int i = 0; i < arr.size()-1; i++)
			sum += Math.abs(arr.get(i) - arr.get(i+1));
		
		return sum;
	}
}
