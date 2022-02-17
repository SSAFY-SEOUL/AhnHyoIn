import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Lab_14502 {
	
	static int N, M;
	static int[][] map;
	
	static List<List<Integer>> grid_0, grid_2; //0, 2 값이 있는 좌표를 각각 저장
	static int size;  //빈칸의 개수
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		grid_0 = new ArrayList();
		grid_2 = new ArrayList();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 0) {  //빈칸의 좌표를 모두 저장
					List<Integer> tmp = new ArrayList();
					tmp.add(i);
					tmp.add(j);
					grid_0.add(tmp);
				}//if
				
				else if(map[i][j] == 2) {  //바이러스의 좌표를 모두 저장
					List<Integer> tmp = new ArrayList();
					tmp.add(i);
					tmp.add(j);
					grid_2.add(tmp);
				}
			}//for j
		}//for i
		
		size = grid_0.size();
		max = 0;
		
		combi(0, 0);
		
		bw.write(max + "\n");
		bw.close();
	}//main
	
	static void combi(int depth, int start) {  //0인 좌표들 3개를 모아서 벽을 세움
		if(depth == 3) {
			max = Math.max(max, BFS());
			
			return;
		}//if
		
		for(int i=start; i<size; i++) {
			int x = grid_0.get(i).get(0);
			int y = grid_0.get(i).get(1);
			
			map[x][y] = 1;  //벽을 세움
			
			combi(depth+1, i+1);
			
			map[x][y] = 0;  //벽을 빈칸으로 원상복구
		}//for i
		
	}//combi
	
	static int BFS() {
		Queue<Integer> queueX = new LinkedList();  //바이러스의 x좌표
		Queue<Integer> queueY = new LinkedList();  //바이러스의 y좌표
		
		for(int i=0; i<grid_2.size(); i++) {
			queueX.add(grid_2.get(i).get(0));
			queueY.add(grid_2.get(i).get(1));
		}//for i
		
		int cnt = grid_0.size() + queueX.size() - 3;  //오염되기 전 안전구역의 개수
		
		visited = new boolean[N][M];

		while(!queueX.isEmpty()) {
			int x = queueX.poll();
			int y = queueY.poll();
			
			cnt--;  //안전구역이 오염되었으므로 1 빼줌
			
			for(int i=0; i<4; i++) {
				int X = x + dx[i];
				int Y = y + dy[i];
				
				if(X >= 0 && X < N && Y >= 0 && Y <M && map[X][Y] == 0 && !visited[X][Y]) {
					queueX.add(X);
					queueY.add(Y);
					visited[X][Y] = true;
				}//if
			}//for
		}//while
		
		return cnt;
	}//BFS
	
}
