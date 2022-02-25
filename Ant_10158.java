import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ant_10158 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());  //가로
		int h = Integer.parseInt(st.nextToken());  //세로
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()); 
		int q = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int timeX = t % (2*w);  //2w의 시간이 지나면 x좌표는 원상태로 돌아옴 -> x좌표를 이동하기 위해 남은 시간
		int timeY = t % (2*h);  //2h의 시간이 지나면 y좌표는 원상태로 돌아옴 -> y좌표를 이동하기 위해 남은 시간
		
		int x = p;
		int y = q;
		int dx = 1;  //방향
		int dy = 1;
		
		int time = 0;
		while(time < timeX) {
			int remainX = 0; //현재 가는 방향으로 얼만큼 갈 수 있는지 계산
			
			if(dx == 1)
				remainX = w - x;
			else
				remainX = x;
			
			if(timeX - time >= remainX) { //남은 시간동안 remainX만큼 갈 수 있는 경우
				x += dx * remainX;
				dx = -dx;
				time += remainX;
			}//if
			
			else {
				x += dx * (timeX - time);  //남은 시간동안 현재 방향으로만 갈 수 있는 경우
				break;
			}//else
		}//while
		
		time = 0;
		while(time < timeY) {
			int remainY = 0; //현재 가는 방향으로 얼만큼 갈 수 있는지 계산
			
			if(dy == 1)
				remainY = h - y;
			else
				remainY = y;
			
			if(timeY - time >= remainY) { //남은 시간동안 remainY만큼 갈 수 있는 경우
				y += dy * remainY;
				dy = -dy;
				time += remainY;
			}//if
			
			else {
				y += dy * (timeY - time);  //남은 시간동안 현재 방향으로만 갈 수 있는 경우
				break;
			}//else
		}//while
				
			
		sb.append(x).append(" ").append(y);
	
		bw.write(sb.toString());
		bw.flush();
	}//main

}
