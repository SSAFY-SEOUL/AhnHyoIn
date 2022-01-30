import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS_BFS_1260 {
	
	static int N, M, V;
	static boolean map[][];
	static boolean visitedDFS[], visitedBFS[];
	static List<Integer> resultDFS, resultBFS;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		V = Integer.parseInt(line[2]);
		
		map = new boolean[N+1][N+1]; //0행, 0열은 비움
		
		visitedDFS = new boolean[N+1];
		visitedBFS = new boolean[N+1];
		
		resultDFS = new ArrayList<>();
		resultBFS = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			line = br.readLine().split(" ");
			map[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = true;
			map[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = true;
		}
		
		visitedDFS[V] = true;
		resultDFS.add(V);
		DFS(V);
		for(int i=0; i<resultDFS.size(); i++)
			System.out.print(resultDFS.get(i) + " ");
		
		System.out.println();
		
		visitedBFS[V] = true;
		BFS(V);
		for(int i=0; i<resultBFS.size(); i++)
			System.out.print(resultBFS.get(i) + " ");
		
	}//main
	
	static void DFS(int V) {
		for(int i=1; i<N+1; i++) {
			if(map[V][i] && !visitedDFS[i]) {
				resultDFS.add(i);
				visitedDFS[i] = true;
				DFS(i);
			}
		}
	}//DFS
	
	static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(V);
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			resultBFS.add(tmp);
			
			for(int i=1; i<N+1; i++) {
				if(map[tmp][i] && !visitedBFS[i]) {
					queue.add(i);
					visitedBFS[i] = true;
				}
			}	
		}
	}//BFS
}
