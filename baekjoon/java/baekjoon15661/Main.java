package baekjoon15661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,r;
	static boolean[] selected;
	static int[][] graph;
	static int result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		graph = new int[n][n];
		selected = new boolean[n];
		r = 0;
		result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		for (r = 1; r < n; r++) {
			permutation(0, 0);			
		}
		System.out.println(result);
		
	}
	static void permutation(int idx, int start) {
		if(idx == r) {
//			System.out.println(Arrays.toString(numbers));
			result = Math.min(result, diff());
			if(result == 0) {
				System.out.println(result);
				System.exit(0);
			}
			return;
		}
		for (int i = start; i < n; i++) {
			if(!selected[i]) {				
				selected[i]=true;
				permutation(idx+1,i+1);
				selected[i]=false;
			}
		}
	}
	static int diff() {
		int start = 0;
		int link = 0;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if(selected[i] && selected[j]) start+=(graph[i][j]+graph[j][i]);
				else if(!selected[i] && !selected[j]) link+=(graph[i][j]+graph[j][i]);
			}
		}
		return Math.abs(start-link);
		
	}

}

