import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10의 10승?! 한번에 결과가 나와야함.((V-A)/(A-B))+1
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int a= Integer.parseInt(token.nextToken());
		int b= Integer.parseInt(token.nextToken());
		int v= Integer.parseInt(token.nextToken());
		System.out.println((int)Math.ceil(((v-a)/(double)(a-b)))+1);
//		System.out.println(((v)/(a-b)));
		
	}
}
