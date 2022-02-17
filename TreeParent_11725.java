import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeParent_11725 {

	static int N;
	static int[] parent;  //노드의 부모 저장
	static List[] vertex;  //연결된 노드를 저장하는 리스트 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		vertex = new ArrayList[N+1];
		for(int i=0; i<N+1; i++)
			vertex[i] = new ArrayList();
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			vertex[x].add(y);  //연결된 노드를 서로 저장
			vertex[y].add(x);  
		}//for i
		
		parent = new int[N+1];
		parent[1] = -1;
		
		setParent(1);  //1부터 연결된 노드들의 부모 설정
		
		for(int i=2; i<N+1; i++) {
			sb.append(parent[i]).append("\n");
		}//for i
		
		bw.write(sb + "\n");
		bw.close();
	}//main
	
	static void setParent(int node) {  //node와 연결된 노드중 아직 부모 노드가 없으면 node로 설정
		for(int i=0; i<vertex[node].size(); i++) {  //node와 연결된 노드를 모두 조사
			int child = (int)vertex[node].get(i);
			
			if(parent[child] == 0) {  //부모 노드가 없는 경우
				parent[child] = node;
				
				setParent(child);
			}//if
		}//for i
		
	}//setParent
	
}
