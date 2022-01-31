//시간 초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ConferenceRoom_19622_DFS {

	static int N;
	static int people[];
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		people=  new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			st.nextToken();
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<2; i++) {
			Stack<Integer> stack = new Stack<>();
			
			stack.push(i);
			
			DFS(i, stack);
		}
		
		System.out.println(max);
		
		br.close();
		
	}//main 
	
	public static void DFS(int v, Stack<Integer> stack){
		
		if((stack.peek() == N-2) || (stack.peek() == N-1)) {
			int tmp = 0;
			for(int i=0; i<stack.size(); i++) {
				tmp += people[stack.get(i)];
			}
			max = Math.max(max, tmp);
		}
		
		else {
			for(int i=v+2; (i<N) && (i<v+4); i++) {
				stack.push(i);
	
				DFS(i, stack);
				
				stack.pop();
			}
		}//else
		
	}//DFS
}
