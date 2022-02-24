import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Rain_14719 {

	static int H, W;
	static int[] block;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		block = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++)
			block[i] = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		for(int i = 0; i <= W-3; i++) { //왼쪽 블록
			int depth = block[i+1];  //왼족 막대기 옆에 차있는 물의 깊이
			
			for(int j = i+2; j < W; j++) {  //오른쪽 블록
				if(depth >= block[i])  //중간에 가로막한 경우
					break;
				
				if(depth >= block[j]) //j번째 블록 입장에서 가로막힌 경우
					continue;
				
				ans += (j-i-1) * (Math.min(block[i], block[j]) - depth);  //물을 채움
				depth = Math.min(block[i], block[j]);
			}//for j
		}//for i
		
		System.out.println(ans);
	}//main

}
