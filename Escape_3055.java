import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Escape_3055 {
	
	static int R, C;
	static char[][] map;
	
	static Queue<Integer> queueX, queueY, queueCnt, waterX, waterY;
	
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};  //상하좌우
	static int[] dy = {0, 0, -1, 1};
	
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		queueX = new LinkedList();
		queueY = new LinkedList();
		queueCnt = new LinkedList();
		
		waterX = new LinkedList();
		waterY = new LinkedList();
		
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j=0; j<C; j++) {
				char c = map[i][j];
			
				if(c == 'S') {  //시작 좌표
					queueX.add(i);	
					queueY.add(j);
					queueCnt.add(0);
					visited[i][j] = true;
				}
				
				else if(c == '*') {  //물 좌표
					waterX.add(i);
					waterY.add(j);
				}//else if
			}//for j
		}//for i
		
		min = R*C; //충분히 큰 수
		
		BFS();
		
		if(min == R*C)
			bw.write("KAKTUS");
		else
			bw.write(min + "\n");
		
		bw.close();
	}//main

	static void BFS() {  //고슴도치 이동
		int time = -1; //물을 고슴도치보다 1초 먼저 이동
		
		Loop1:
		while(!queueX.isEmpty()) {
			int x = queueX.poll();
			int y = queueY.poll();
			int cnt = queueCnt.poll();
			
			if(cnt > time) {
				waterMove(x, y);  //물을 먼저 확장
				time++;
			}//if
		
			for(int d=0; d<4; d++) {
				int X = x + dx[d];
				int Y = y + dy[d];
				
				if(X >= 0 && X < R && Y >= 0 && Y < C && !visited[X][Y] && 
												(map[X][Y] == '.' || map[X][Y] == 'D')) {
					queueX.add(X);
					queueY.add(Y);
					queueCnt.add(cnt+1);
					visited[X][Y] = true;
					
					if(map[X][Y] == 'D') { //도착
						min = cnt+1;
						break Loop1;
					}//if
				}//if
			}//for d
		}//while
	}//BFS
	
	static void waterMove(int posX, int posY) {
		int size = waterX.size();  //현재 물 좌표의 크기
		
		for(int i=0; i<size; i++) {
			int x = waterX.poll();
			int y = waterY.poll();
			
			for(int d=0; d<4; d++) {
				int X = x + dx[d];
				int Y = y + dy[d];
				
				if(X >= 0 && X < R && Y >= 0 && Y < C && map[X][Y] == '.' && 
										!(X == posX && Y == posY)) {  //고슴도치가 있으면 확장X
					map[X][Y] = '*';
					waterX.add(X);
					waterY.add(Y);
				}//if
			}//for d
		}//for i
	}//waterMove

}//END

