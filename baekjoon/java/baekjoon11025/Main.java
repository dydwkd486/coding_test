import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_뭐이 {
	static int n,k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int count = 0;
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		for (int i = 1; i <= n; i++) {
			count = (count+k)%i;
		}
		System.out.println(count+1);
	}
}
