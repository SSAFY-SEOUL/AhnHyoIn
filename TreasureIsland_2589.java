import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland_2589 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new char[N][M];
			
		for(int i=0; i<N; i++) 
			map[i] = br.readLine().toCharArray();

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 'L'){
					checkMax(i, j);
				}
			}//for j
		}//for i
		
		System.out.println(max);
			
	}//main
	
	static int N, M;
	static char[][] map;
	static int max = 0;
	static boolean[][] visited;
	static int[] direcX = {-1, 1, 0, 0};
	static int[] direcY = {0, 0, -1, 1};	
	
	public static class Grid{
		int x;
		int y;
		int time;
		
		public Grid(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
	public static void checkMax(int i, int j) {
		visited = new boolean[N][M];
		
		Queue<Grid> queue = new LinkedList<>();
	
		queue.add(new Grid(i, j, 0));
		
		while(!queue.isEmpty()) {
			Grid grid = queue.poll();
			int x = grid.x;
			int y = grid.y;
			
			max = Math.max(max, grid.time);
		
			visited[x][y] = true;

			for(int k=0; k<4; k++) {
				 int x2 = x + direcX[k];
				 int y2 = y + direcY[k];
				
				if((x2 >= 0) && (x2 < N) && (y2 >= 0) && (y2 < M) && (map[x2][y2] == 'L') && !visited[x2][y2])
					queue.add(new Grid(x2, y2, grid.time+1));
			}//for k
			
		}//while
	}//checkMax
}
