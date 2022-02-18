import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM12_15666 {
	
	static int N, M, size;
	static int[] su;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		su = new int[N];
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(!contains(su, i, num)) {  //중복 제거
				su[i] = num;
				size++;  //중복을 제거한 총 숫자의 개수
			}//if
		}//for i
		
		Arrays.sort(su);  //su를 오름차순 정렬
		
		int[] arr = new int[M];  //수열을 담을 배열
		
		perm(0, arr);
		
		bw.write(sb + "\n");
		bw.close();
	}//main
	
	static void perm(int depth, int[] arr) {
		if(depth >= 2 && arr[depth-1] < arr[depth-2])  //비내림차순 검사
			return;
		
		if(depth == M) {
			for(int i=0; i<M; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			
			return;
		}//if
		
		for(int i = N-size; i < N; i++) {
			arr[depth] = su[i];
		
			perm(depth+1, arr);
		}//for i
	}//perm
	
	static boolean contains(int[] su, int length, int num) {  //num이 su에 있는지 검사
		boolean contain = false;
		
		for(int i=0; i<length; i++) {
			if(su[i] == num) {
				contain = true;
				break;
			}//if
		}//for i
				
		return contain;
	}//contains
	
}
