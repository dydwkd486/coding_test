import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int n;
	static boolean[] visited;
	static int[] n_list_x;
	static int[] n_list_y;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			String[] token = br.readLine().split(" ");
			n_list_x = new int[n+2];
			n_list_y = new int[n+2];
			visited = new boolean[n+2];
			result = Integer.MAX_VALUE;
			n_list_x[0] = Integer.parseInt(token[0*2]);
			n_list_y[0] = Integer.parseInt(token[0*2+1]);
			for (int i = 2; i < n+2; i++) {
				n_list_x[i-1] = Integer.parseInt(token[i*2]);
				n_list_y[i-1] = Integer.parseInt(token[i*2+1]);
			}
			n_list_x[n+1] = Integer.parseInt(token[1*2]);
			n_list_y[n+1] = Integer.parseInt(token[1*2+1]);
			dfs(1,n_list_x[0],n_list_y[0],0);
			System.out.println("#"+tc+" "+result);
		}
	}
	static void dfs(int idx,int x,int y,int sum) {
		if(result<sum) {
			return;
		}
		if(idx==n+1) {
//			System.out.println(sum+Math.abs(y-n_list_y[n+1])+Math.abs(x-n_list_x[n+1]));
			result = Math.min(result, sum+Math.abs(y-n_list_y[n+1])+Math.abs(x-n_list_x[n+1]));
			return;
		}
		for (int i = 1; i < n+1; i++) {
			if(visited[i]==false) {
				visited[i] = true;
				dfs(idx+1,n_list_x[i],n_list_y[i],sum+Math.abs(y-n_list_y[i])+Math.abs(x-n_list_x[i]));
				visited[i] = false;
				
			}
		}
		
	}
	static void print() {
		for (int i : n_list_x) {
			System.out.print(i+" ");
		}
		System.out.println();
		for (int i : n_list_y) {
			System.out.print(i+" ");
		}
	}
}
