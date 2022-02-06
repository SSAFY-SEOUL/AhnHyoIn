import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class RotatingSushi_2531_Set {
	
	static int N, d, k, c;
	static int[] sushi_type;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi_type = new int[N];
		
		for(int i=0; i<N; i++)
			sushi_type[i] = Integer.parseInt(br.readLine());
		
		int max = 0;  //max의 최댓값은 k+1
		
		Set<Integer> eat = new HashSet(); //연속으로 먹을 k개의 초밥들
		
		for(int i=0; i<N; i++) {
			
			int idx = i;
			
			for(int j=0; j<k; j++) {
				eat.add(sushi_type[idx]);
			
				idx = (++idx) % N;
			}
				
			eat.add(c);
			
			max = Math.max(max, eat.size());
			
			if(max == k+1)
				break;
			
			eat.clear();
		}//for i
		
		System.out.println(max);
		
	}//main

}//class RotatingSushi
