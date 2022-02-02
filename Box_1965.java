import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Box_1965 {

	static int n;
	static int[] size, max_length;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		size = new int[n];
		max_length = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++)
			size[i] =Integer.parseInt(st.nextToken());

		max_length[0] = 1;
		
 		DP();
 		
 		Arrays.sort(max_length);
 		System.out.println(max_length[n-1]);
		
	}//main
	
	static void DP() {
		for(int i=1; i<n; i++) {
			max_length[i] = searchFrontMax(i) + 1;
		}
	}//DP
	
	static int searchFrontMax(int index) {
		int max = 0;
		
		for(int i=index-1; i>=0; i--) {
			if((size[i] < size[index]) && (max_length[i] > max)) {
				max = max_length[i];
			}
		}
		
		return max;
	}//searchFrontMax

}
