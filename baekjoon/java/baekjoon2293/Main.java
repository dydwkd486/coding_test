package baekjoon2293;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n,k,n_list[],dp[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		n = Integer.parseInt(token[0]);
		k = Integer.parseInt(token[1]);
		n_list = new int[n];
		dp = new int[k+1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			n_list[i] = Integer.parseInt(br.readLine());
		}
		for (int i : n_list) {
			for (int j = 0; j <= k; j++) {
				if(j-i>=0)
				dp[j] += dp[j-i];
			}
		}
		System.out.println(dp[k]);
	}

}
