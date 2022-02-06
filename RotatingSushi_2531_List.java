import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class RotatingSushi_2531_List {
	
	static int N, d, k, c;
	static int[] sushi;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N];
		
		for(int i=0; i<N; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		
		List<Integer> eat = new ArrayList(); //연속으로 먹을 k개의 초밥들
	
		int sum = 0; //eat에 있는 초밥 종류 세기
		
		for(int i=0; i<k; i++) {
			if(!eat.contains(sushi[i]))
				sum++;
			eat.add(sushi[i]);
		}//for i
		
		int max = !eat.contains(c) ? sum+1 : sum;
		
		for(int i=1; i<N; i++) {
			int eat_remove = eat.get(0);
		
			eat.remove(0);
	
			if(!eat.contains(eat_remove))  //제거한 초밥이 리스트에 없을때
				sum--;
			
			int eat_add = sushi[(i+k-1)%N];
			
			if(!eat.contains(eat_add)) //추가할 초밥이 리스트에 없을 때
				sum++;
			
			eat.add(eat_add);
			
			int tmp_max = !eat.contains(c) ? sum+1 : sum;
			
			max = Math.max(max, tmp_max);
			
			if(max == k+1)
				break;
		}//for i
		
		System.out.println(max);
		
	}//main

}//class RotatingSushi
