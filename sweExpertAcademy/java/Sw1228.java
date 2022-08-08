import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=10 ; tc ++) {
			token = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(token.nextToken());
			List<Integer> n_list = new ArrayList<Integer>();
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				n_list.add(Integer.parseInt(token.nextToken()));
			}
			token = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(token.nextToken());
			token = new StringTokenizer(br.readLine(),"I");
			
			for (int i = 0; i < m; i++) {
				String[] temp = token.nextToken().split(" ");
				int temp_x = Integer.parseInt(temp[1]);
				int temp_y = Integer.parseInt(temp[2]);
				for (int j = 0; j < temp_y; j++) {
					n_list.add(temp_x+j, Integer.parseInt(temp[j+3]));
				}
			}
			sb.append("#"+tc+" ");
			for (int i = 0; i < 10; i++) {
				sb.append(n_list.get(i)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
