import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hansu_1065 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());  // N 1000이하의 자연수
		
		//1~99
		if(N < 100)
			System.out.println(N);
		
		//100~110
		else if(N < 111)
			System.out.println(99);
		
		//111~999
		else if (N < 1000)
			System.out.println(count(N));
		
		//1000
		else
			System.out.println(count(999));
		
	}//main
	
	static int count(int N) {
		int cnt = 99;
		
		for(int i=111; i<=N; i++) {
			int[] diff = new int[2];   //각 자릿수의 차이를 저장
			
			for(int j=0; j<2; j++)  
				diff[j] = (int)(i / Math.pow(10, j)) % 10 - (int)(i / Math.pow(10, j+1)) % 10;
	
			if (diff[0] == diff[1])
				cnt++;
		}
		
		return cnt;
	}
	
}
