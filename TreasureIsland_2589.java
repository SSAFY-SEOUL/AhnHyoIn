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
				if((map[i][j] == 'L')){
					int near = cntNear(i, j);
					
					boolean check = false;
					int[] arr = {1, 2, 3, 4, 6, 8, 9, 12};  //최댓값을 갱신할 수 있는 경우
					
					for(int k=0; k<arr.length; k++) {
						if(near == arr[k]) {
							check = true;
							break;
						}	
					}
					
					if(check) {  
						visited = new boolean[N][M];
						visited[i][j] = true;
						BFS(i, j);
					}	 
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
	
	static int cntNear(int i, int j) {  //이웃한 L의 모양을 리턴
		int cnt = 0;
		
		if(((i-1) >= 0) && map[i-1][j] == 'L')  //up
			cnt += 1;
		
		if(((i+1) < N) && map[i+1][j] == 'L') //down
			cnt += 4;
	
		if(((j-1) >= 0) && map[i][j-1] == 'L') //left
			cnt += 8;
	
		if(((j+1) < M) && map[i][j+1] == 'L') //right
			cnt += 2;
		
		return cnt;
	}
	
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
	
	public static void BFS(int i, int j) {
		Queue<Grid> queue = new LinkedList<>();
	
		queue.add(new Grid(i, j, 0));
		
		while(!queue.isEmpty()) {
			Grid grid = queue.poll();
			int x = grid.x;
			int y = grid.y;
			
			max = Math.max(max, grid.time);
		
			//visited[x][y] = true;

			for(int k=0; k<4; k++) {
				 int x2 = x + direcX[k];
				 int y2 = y + direcY[k];
				
				if((x2 >= 0) && (x2 < N) && (y2 >= 0) && (y2 < M) && (map[x2][y2] == 'L') && !visited[x2][y2]) {
					queue.add(new Grid(x2, y2, grid.time+1));
					visited[x2][y2] = true;
				}
			}//for k
			
		}//while
	}//checkMax
}
