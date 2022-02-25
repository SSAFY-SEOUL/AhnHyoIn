import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MakeRectangle_8320 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int i=1; i<=n; i++) {  //세로
			for(int j=i; j<=n; j++) {  //가로
				if(i*j <= n)
					cnt++;
			}//for j
		}//for i

		bw.write(cnt + "\n");
		bw.close();
	}//main

}
