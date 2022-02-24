import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BottleneckTravellingSalesmanProblem_24512 {
	
	static int N, M;
	static int[][] graph;
	static int[] route; //최종 경로
	static int min = Integer.MAX_VALUE;  //최댓값의 최소

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[u][v] = c;
		}//for i
		
		
		for(int i=1; i<=N; i++) {  //모든 점을 출발점으로 
			boolean[] visited = new boolean[N+1];
			visited[i] = true;
			
			int[] arr = new int[N+1];  //이동 경로
			arr[0] = i;
			
			DFS(1, i, visited, arr, 0);
		}//for i
		
		if(min == Integer.MAX_VALUE)
			sb.append(-1);
		
		else {
			sb.append(min).append("\n");
			for(int i=0; i<N; i++)
				sb.append(route[i]).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}//main

	static void DFS(int depth, int start, boolean[] visited, int[] arr, int max) {
		
		if(depth == N) {
			if(graph[arr[N-1]][arr[0]] != 0) {  //출발점으로 돌아올 수 있는지 검사
				max = Math.max(max, graph[arr[N-1]][arr[0]]);
			
				if(max < min) {
					min = max;
					route = arr.clone();
				}//if
			}
			
			return;
		}//if
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && graph[start][i] != 0) {  //갈 수 있는 경로
				arr[depth] = i;
				visited[i] = true;
				
				DFS(depth+1, i, visited, arr, Math.max(max, graph[start][i]));
				
				visited[i] = false;
			}//if
		}//for i
	}//DFS
}

