package baekjoon1149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,graph[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		n = Integer.parseInt(br.readLine());
		graph = new int[n][3];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				graph[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		for (int i = 1; i < n; i++) {
			graph[i][0] = Math.min(graph[i-1][1], graph[i-1][2])+ graph[i][0];
			graph[i][1] = Math.min(graph[i-1][0], graph[i-1][2])+ graph[i][1];
			graph[i][2] = Math.min(graph[i-1][0], graph[i-1][1])+ graph[i][2];
		}
//		System.out.println(Arrays.toString(graph[n-1]));
		System.out.println(Math.min(graph[n-1][0], Math.min(graph[n-1][1], graph[n-1][2])));
		
	}
}
