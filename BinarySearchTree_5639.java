import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class BinarySearchTree_5639 {

	static List<Integer> pre = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		while(true) {
			str = br.readLine();
			if(str == null || str.equals(""))
				break;
			pre.add(Integer.parseInt(str));
		}//while
		
		findTree(0, pre.size()-1);  //루트 노드를 시작으로 트리의 형태 찾음
		
		bw.write(sb + "\n");
		bw.close();
	}//main
	
	static void findTree(int start, int end) {  //start = 부모노드, end = 서브트리의 마지막 노드
		if(start == end) {
			sb.append(pre.get(start) + "\n");  //단말 노드 추가
			return;
		}

		boolean left_child = false; //왼쩍 서브트리를 가질 수 있는지 검사
		boolean right_child = false; //오른쪽 서브트리를 가질 수 있는지 검사
		
		int cut = start;  //왼쪽 서브트리와 오른쪽 서브트리를 자르는 인덱스
		for(int i = start+1; i <= end; i++) {
			cut++;
			if(pre.get(i) < pre.get(start))
				left_child = true;
			
			else if(pre.get(i) > pre.get(start)) {
				right_child = true;
				break;
			}
		}//for i
		
		if(left_child && right_child) {  //양쪽 서브트리를 모두 가지는 경우
			findTree(start+1, cut-1); //왼쪽 서브트리
			
			findTree(cut, end); //오른쪽 서브트리
		}
		
		else if(left_child)  //왼쪽 서브트리만 갖는 경우
			findTree(start+1, end); //왼쪽 서브트리
		
		else  //오른쪽 서브트리만 갖는 경우
			findTree(start+1, end); //오른쪽 서브트리
		
		sb.append(pre.get(start) + "\n");  //부모 노드 추가
	}//findTree

}
