import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(token.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			token = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(token.nextToken());
			int m = Integer.parseInt(token.nextToken());
			int result = -1;
			int[] n_list = new int[n];
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < n_list.length; i++) {
				n_list[i] = Integer.parseInt(token.nextToken());
			}
			for(int i = 0;i<n_list.length-1;i++) {
				for (int j = n_list.length-1; j > i; j--) {
					int temp = n_list[i]+n_list[j];
					if(m>=temp && result<temp) {
						result = temp;
					}
				}
			}
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(result);
			sb.append("\n");
		}// 테스트 케이스 end
		System.out.println(sb);
	}
}
