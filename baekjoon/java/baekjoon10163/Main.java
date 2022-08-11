package BJ10163;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[1001][1001];
		int[] count = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			String[] token = br.readLine().split(" ");
			int a = Integer.parseInt(token[0]);
			int b = Integer.parseInt(token[1]);
			int w = Integer.parseInt(token[2]);
			int h = Integer.parseInt(token[3]);
			
			for (int y = b; y < b+h; y++) {
				for (int x = a; x < a+w; x++) {
					graph[y][x]=i;
				}
			}
		}
		for (int y = 0; y < 1001; y++) {
			for (int x = 0; x < 1001; x++) {
				count[graph[y][x]]++;
			}				
		}
		for (int i = 1; i < n+1; i++) {
			sb.append(count[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
