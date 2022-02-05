import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Coin0_11047 {

	static int N, K;
	static int[] value;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		K = Integer.parseInt(line[1]);
		
		value = new int[N];
		
		for(int i=0; i<N; i++)
			value[i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;  //현재까지 누적된 동전의 개수
		int res = K;  //앞으로 바꿔야하는 돈
		
		for(int i=N-1; i>=0; i--) {
			int tmp_cnt = res / value[i]; //현재 가치에서 필요한 동전 개수
			
			cnt += tmp_cnt; 
		
			res -= value[i] * tmp_cnt;
			
			if(res == 0)
				break;
		}//for i
		
		System.out.println(cnt);
	}//main

}//class Coin0_11047
