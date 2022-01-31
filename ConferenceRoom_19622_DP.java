//https://krockseed.tistory.com/1 참고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ConferenceRoom_19622_DP {

	static int N;
	static int people[];
	static int dp[][];
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		people=  new int[N];
		dp = new int[N][2]; 
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			st.nextToken();
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = 0;
		dp[0][1] = people[0];
		
		DP();
		
		max = Math.max(dp[N-1][0], dp[N-1][1]);
		
		System.out.println(max);
	
		br.close();
		
	}//main 
	
	static void DP() {
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = dp[i-1][0] + people[i];		
		}
	}//DP

}
