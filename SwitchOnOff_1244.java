import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnOff_1244 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());  //스위치 개수
		int[] SWITCH = new int[N+1];  //스위치 정보
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) 
			SWITCH[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());  //학생 수
		int[][] student = new int[M][2];  //학생 정보
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			student[i][0] = Integer.parseInt(st.nextToken());  //성별
			student[i][1] = Integer.parseInt(st.nextToken());  //스위치 번호
		}//for i
		
		for(int i=0; i<M; i++) {
			if(student[i][0] == 1) {  //남학생
				int num = student[i][1];
				
				for(int j=num; j<=N; j+=num) { //배수만큼 스위치 변경
					if(SWITCH[j] == 0)
						SWITCH[j] = 1;
					else
						SWITCH[j] = 0;
				}//for j
			}//if
				
			else {  //여학생
				int num = student[i][1];
				int range = 0;  //대칭 범위
				
				while(num-(range+1) >= 1 && num+(range+1) <= N && 
						SWITCH[num-(range+1)] == SWITCH[num+(range+1)]) {
					range++;
				}//while
				
				for(int j=num-range; j<=num+range; j++) { //대칭 구간만큼 스위치 변경
					if(SWITCH[j] == 0)
						SWITCH[j] = 1;
					else
						SWITCH[j] = 0;
				}//for j
			}//else
		}//for i
		
		for(int i=1; i<=N; i++) {
			sb.append(SWITCH[i]).append(" ");
			
			if(i % 20 == 0)
				sb.append("\n");
		}//for i
		
		System.out.println(sb);
	}//main
	
}
