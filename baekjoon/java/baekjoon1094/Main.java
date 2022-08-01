
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int result = 0;
	static int stick = 64;
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		 while(n>0) {
			 if(stick<=n) {
				 result+=1;
				 n=n-stick;
			 }
			 else {
				 stick=stick/2;
				 }
		 }
		 System.out.println(result);
		
	}
}
