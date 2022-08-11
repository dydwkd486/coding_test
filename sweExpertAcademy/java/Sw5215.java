package D3_햄버거다이어트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] t_list;
	static  int[] k_list;
	static int n;
	static boolean[] n_boolean;
	static int count;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			token = new StringTokenizer(br.readLine());
			n = Integer.parseInt(token.nextToken());
			int l = Integer.parseInt(token.nextToken());
			count= 0;
			t_list = new int[n];
			k_list = new int[n];
			n_boolean = new boolean[n];
			for (int i = 0; i < n; i++) {
				token = new StringTokenizer(br.readLine());
				t_list[i] = Integer.parseInt(token.nextToken());
				k_list[i] = Integer.parseInt(token.nextToken());
			}
			
			dfs(0,0,0,l);
			System.out.println("#"+tc+" "+count);
		}
	}
	static void dfs(int idx, int t,int k,int l) {
		if(k<l) {
			if(idx==n) {
				count = Integer.max(count, t);
			}
			else {
				dfs(idx+1,t+t_list[idx],k+k_list[idx],l);
				dfs(idx+1,t,k,l);							
			}
		}
	}
}

