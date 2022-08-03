package baekjoon11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int[] n_list = new int[n+1];
		token = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			n_list[i] = n_list[i-1]+Integer.parseInt(token.nextToken());
		}
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			sb.append(n_list[b] - n_list[a - 1]).append('\n');
		}
		System.out.println(sb);
	}
}
