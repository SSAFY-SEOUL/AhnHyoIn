import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixSquared_10830 {

	static int N;
	static int[][] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		int[][] A = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}//for i
		
		result = new int[N][N];
		
		if(B == 1)
			result = A;
		else
			square(A, B);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				sb.append(result[i][j] % 1000 + " ");
			sb.append("\n");
		}

		bw.write(sb + "\n");
		bw.flush();
	}//main

	static void square(int[][] A, long B) { //A를 제곱하고 result에 저장
		if(B == 1)
			return;
		
		int[][] matrix = new int[N][N];
		int[][] matrix_T = new int[N][N];
		
		for(int i=0; i<N; i++) {  //A를 깊은 복사
			for(int j=0; j<N; j++) {
				matrix[i][j] = A[i][j];
				matrix_T[i][j] = A[i][j];
			}
		}//for i
		
		for(int i=0; i<N; i++) { //matrix_T를 대칭변환
			for(int j=i+1; j<N; j++) {
				int tmp = matrix_T[i][j];
				matrix_T[i][j] = matrix_T[j][i];
				matrix_T[j][i] = tmp;
			}
		}//for i
		
		int[] row = new int[N];  //matrix의 행
		int[] col = new int[N];  //matrix_T의 행
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) { //matrix * matrix_T 계산
				row = matrix[i];  
				col = matrix_T[j];
			
				int tmp = 0;
				for(int idx=0; idx<N; idx++) {
					tmp += row[idx] * col[idx];
					result[i][j] = tmp % 1000;
				}
			}//for j
		}//for i
	
		square(result, B/2);
		
		if(B % 2 == 1) { //B가 홀수이면 현재 result * matrix_T 계산
			
			for(int i=0; i<N; i++) {  //result를 깊은 복사
				for(int j=0; j<N; j++)
					matrix[i][j] = result[i][j];
			}//for i
	
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) { //matrix * matrix_T 계산
					row = matrix[i];  
					col = matrix_T[j];
			
					int tmp = 0;
					for(int idx=0; idx<N; idx++) {
						tmp += row[idx] * col[idx];
						result[i][j] = tmp % 1000;
					}
				}//for j
			}//for i
			
		}//if B 홀수
	}//square
}

