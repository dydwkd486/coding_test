package Beakjoon2961;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] s;
	static int[] b;
	static int result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		s = new int[n];
		b = new int[n];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(token.nextToken());
			b[i] = Integer.parseInt(token.nextToken());	
		}
		dfs(0,1,0);
		System.out.println(result);
		
	}
	static void dfs(int idx,int s_sum,int b_sum) {
		if(idx == n ) {
			if(b_sum!=0)
				result = Math.min(result, Math.abs(b_sum-s_sum));
			return;
		}
		
		dfs(idx+1,s_sum*s[idx],b_sum+b[idx]);
		dfs(idx+1,s_sum,b_sum);
		
		
	}
}

