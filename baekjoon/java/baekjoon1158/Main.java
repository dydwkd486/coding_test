import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder("<");
		int count = 0;
		n = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		List<Integer> n_list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			n_list.add(i);
		}
		while(n_list.size()>1) {
			count = (count+k-1)%n_list.size();
//			System.out.println(n_list+" : "+count);
			sb.append(n_list.remove(count)+", ");
		}
		sb.append(n_list.remove(0)+">");
		System.out.println(sb);
		
	}
}
