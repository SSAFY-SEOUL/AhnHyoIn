import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceStack_2116 {
	
	static int N;
	static int[][] opposite; //각 숫자와 마주보는 숫자를 저장 
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		opposite = new int[N+1][7];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			
			opposite[i][A] = F;  //A-F
			opposite[i][B] = D;  //B-D
			opposite[i][C] = E;  //C-E
			opposite[i][D] = B;
			opposite[i][E] = C;
			opposite[i][F] = A;
		}//for i
		
		for(int i=1; i<=6; i++)
			result = Math.max(result, stack(opposite[1][i]));
		
		System.out.println(result);
	}//main
	
	static int stack(int down) { //첫번째 주사위의 아래에 오는 수를 다르게 하여 주사위 쌓기 
		int sum = 0;
		
		for(int i=1; i<=N; i++) {
			sum += getMax(down, opposite[i][down]);
			down = opposite[i][down];
		}//for i
		
		return sum;
	}//stack

	static int getMax(int a, int b) {  //주사위에서 a, b를 제외한 가장 큰 숫자 리턴
		int max = 0;
		
		for(int i=1; i<=6; i++) {
			if(i != a && i != b)
				max = Math.max(max, i);
		}//for i
		
		return max;
	}//getMax
	
}

