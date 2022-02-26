import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class WordFlip_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] arr = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		
		int len = arr.length;
		boolean flip = true;
		
		for(int i=0; i<len; i++) {
			if(arr[i] == '<') {  //태그 시작
				while(!stack.isEmpty()) {  //이전까지 스택에 남아있는 단어 처리
					sb.append(stack.pop());
				}//while
				
				sb.append(arr[i]);
				flip = false;
			}//if
			
			else if(arr[i] == '>') {  //태그 종료
				sb.append(arr[i]);
				flip = true;
			}//else if
			
			else if(arr[i] == ' '){  
				while(!stack.isEmpty()) {  //공백 전까지 스택에 남아있는 단어처리
					sb.append(stack.pop());
				}//while
				
				sb.append(" ");
			}//else
			
			else {
				if(flip)
					stack.add(arr[i]);
				else
					sb.append(arr[i]);
			}//else
		}//for i
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}//while
		
		System.out.println(sb);
	}//main

}
