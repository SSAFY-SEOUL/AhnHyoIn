import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NightMove_7562 {

	static int N, startX, startY, endX, endY;
	static int[][] direc = {{-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}, 
							{1, 2}, {1, -2}, {2, -1}, {2, 1}};
	static Queue<Integer> qX, qY;
	static int [][] len;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); //체스판 한 변의 길이
			len = new int[N][N];  //이동 횟수
			visited = new boolean[N][N]; 
					
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); //나이트의 현재 칸
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
				
			st = new StringTokenizer(br.readLine(), " "); //나이트가 이동하려 하는 칸
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			len[startX][startY] = 0;
			visited[startX][startY] = true;
			
			qX = new LinkedList<>();
			qY = new LinkedList<>();
			
			qX.add(startX);
			qY.add(startY);
			
			BFS();
			
			sb.append(len[endX][endY] + "\n");
		}//for test_case
		
		bw.write(sb + "\n");
		bw.flush();
	}//main
	
	static void BFS() {
		while(!qX.isEmpty()) {
			int x = qX.poll();
			int y = qY.poll();
			
			if((x == endX) && (y == endY))
				break;
			
			for(int i=0; i<8; i++) {
				int X = x + direc[i][0];
				int Y = y + direc[i][1];
				
				if((X >= 0) && (X < N) && (Y >= 0) && (Y < N)) {
					if(!visited[X][Y]) {
						qX.add(X);
						qY.add(Y);
						
						len[X][Y] = len[x][y] + 1;
						visited[X][Y] = true;
					}
				}//if
			}//for i
		}//while
	}//BFS
}
