import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame_3085 {

	static int N;
	static char[][] map;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i=0; i<N; i++)
			map[i] = br.readLine().toCharArray();
		
		//전체에 대해 먼저 검사
		for(int i=0; i<N; i++) {
			max = Math.max(max, checkRow(i));
			if(max == N) {
				System.out.println(max);
				return;
			}
		}
		
		for(int j=0; j<N; j++) {
			max = Math.max(max, checkColumn(j));
			if(max == N) {
				System.out.println(max);
				return;
			}
		}
		
		//오른쪽 위치와 바꿈
		Loop1:
		for(int i=0; i<N; i++) {
			for(int j=0; j<(N-1); j++) {
				if(map[i][j] != map[i][j+1]) {
					char left = map[i][j];
					char right = map[i][j+1];
					
					map[i][j] = right;
					map[i][j+1] = left;
					
					max = Math.max(max, checkRow(i)); //두 사탕이 위치한 행
					max = Math.max(max, checkColumn(j)); //현재 사탕이 위치한 열
					max = Math.max(max, checkColumn(j+1)); //현재 사탕의 오른쪽이 위치한 열
					
					map[i][j] = left;
					map[i][j+1] = right;
				}
				
				if(max == N) 
					break Loop1;
			}
		}//for i
		
		//아래 위치와 바꿈
		Loop2:
		for(int i=0; i<(N-1); i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != map[i+1][j]) {
					char up = map[i][j];
					char down = map[i+1][j];
							
					map[i][j] = down;
					map[i+1][j] = up;
							
					max = Math.max(max, checkRow(i)); //두 사탕이 위치한 행
					max = Math.max(max, checkRow(i+1)); //현재 사탕의 아래쪽이 위치한 행
					max = Math.max(max, checkColumn(j)); //두 사탕이 위치한 열
							
					map[i][j] = up;
					map[i+1][j] = down;
				}
						
				if(max == N) 
					break Loop2;
			}
		}//for i
		
		System.out.println(max);

	}//main

	static int checkRow(int i) {  //i번째 행의 최대 연속값
		int maxG = 0;
	
		//0번째 
		int cnt = 1;
		int y = 0;
		while(y < (N-1)) {
			if(map[i][y] == map[i][y+1]) {
				y += 1;
				cnt++;
			}
			else
				break;
		}
		
		maxG = Math.max(maxG, cnt);
			
		//나머지 
		for(int j=1; j<(N-1); j++) {
			if(map[i][j] != map[i][j-1]) {
				cnt = 1;
				y = j;
				
				while(y < (N-1)) {
					if(map[i][y] == map[i][y+1]) {
						y += 1;
						cnt++;
					}
					else
						break;
				}//while
			}//if
			maxG = Math.max(maxG, cnt);
		}//for
			
		return maxG;
	}//checkRow
	
	static int checkColumn(int j) { //j번째 열의 최대 연속값
		int maxS= 0;
	
		//0번째 
		int cnt = 1;
		int x = 0;
		while(x < (N-1)) {
			if(map[x][j] == map[x+1][j]) {
				x += 1;
				cnt++;
			}
			else
				break;
		}
		
		maxS = Math.max(maxS, cnt);
		
		//나머지 
		for(int i=1; i<(N-1); i++) {
			if(map[i][j] != map[i-1][j]) {
				cnt = 1;
				x = i;
				
				while(x < (N-1)) {
					if(map[x][j] == map[x+1][j]) {
						x += 1;
						cnt++;
					}
					else
						break;
				}//while
			}//if
			maxS = Math.max(maxS, cnt);
		}//for
			
		return maxS;
	}//checkColumn

}
	
