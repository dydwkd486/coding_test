import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sw1989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int T=1;T<n+1;T++) {
			int result = 1;
			String[] n_list = br.readLine().split("");
//			System.out.println(n_list);
			for(int i=0;i<n_list.length;i++) {
//				System.out.println(n_list[i]+","+n_list[n_list.length-i-1]);
				if(!n_list[i].equals(n_list[n_list.length-i-1])) {
					result = 0;
					break;
				}
			}
			System.out.println("#"+T+" "+result);
		}
	}
}
