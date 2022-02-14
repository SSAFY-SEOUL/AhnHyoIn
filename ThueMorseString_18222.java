import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class ThueMorseString_18222 {
	
	static BigInteger K, one, two, X;
	static boolean change = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String k = br.readLine();
		K = new BigInteger(k);
		one = new BigInteger("1");
		two = new BigInteger("2");
		
		answer();  //K가 1로부터 몇번의 단계를 거쳐서 왔는지 찾음
		
		if(change) //홀수번의 단계를 거침
			bw.write(1 + "\n");
		
		else  //짝수번의 단계를 거침
			bw.write(0 + "\n");
		
		bw.close();
		
	}//main
	
	static BigInteger findX() {// K 이상의 자연수 중 2의 제곱수 찾기
		X = new BigInteger("1"); 
		
		while(K.compareTo(X) == 1) {  //K > X 이면  X*2
			X = X.multiply(two);
		}//while
		
		return X;
	}//findX
	
	static void answer() {  
		while(K.compareTo(one) == 1) { //K > 1
			X = findX();
			
			K = X.divide(two).subtract((X.subtract(K))); //K = (X/2) - (X-K)
			
			change = !change;
		}//while
	}//answer
}

