package baekjoon9742;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,count,num;
	static char[] n_list, ans;
	static boolean select[];
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		while(true) {
			String data = br.readLine();
			if(data == null) {
				break;
			}
			token = new StringTokenizer(data);
			
			num=0;
			sb = new StringBuilder(token.nextToken());
			n_list = sb.toString().toCharArray();
			count = Integer.parseInt(token.nextToken());
			ans = new char[n_list.length];
			select = new boolean[n_list.length];
			sb.append(" ").append(count).append(" = ");
			per(0);
			if(num<count) {
				sb.append("No permutation");
			}
			System.out.println(sb);
		}
	}
	static void per(int cnt) {
		if(cnt==n_list.length) {
			if(++num == count)
			{
				for (int i = 0; i < ans.length; i++) {
					sb.append(ans[i]);
				}
			}
			return;
		}
		for (int i = 0; i < n_list.length; i++) {
			if (select[i]) continue;
			select[i]= true;
			ans[cnt] = n_list[i];
			per(cnt+1);
			select[i]= false;
		}
	}

}
