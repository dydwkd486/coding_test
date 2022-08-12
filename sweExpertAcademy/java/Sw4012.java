package Sw4012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n,r;
	static int[][] graph;
	static int[] input;
	static int[] a,b;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			r = n/2;
			graph = new int[n][n];
			input = new int[n];
			result = Integer.MAX_VALUE;
			a = new int[r];
			b = new int[r];
			for (int i = 0; i < input.length; i++) {
				input[i]=i;
			}
			for (int i = 0; i < graph.length; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < graph.length; j++) {
					graph[i][j]=Integer.parseInt(token.nextToken());
				}
			}
			com(0,0);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		} //tc end
		System.out.println(sb);
		
		
	}
	static void com(int idx, int cnt) {
		if(cnt == r) {
			int count=0;
			for (int i = 0; i < n; i++) {
				boolean temp = false;
				for (int j = 0; j < a.length; j++) {
					if(a[j]==i) {
						temp=true;
						break;
					}
				}
				if(!temp) {
					b[count++] = i;
				}
			}
			int temp1 = 0;
			int temp2 = 0;
			for (int i = 0; i < a.length-1; i++) {
				for (int j = i+1; j < a.length; j++) {
					temp1 += graph[a[i]][a[j]]+graph[a[j]][a[i]];
					temp2 += graph[b[i]][b[j]]+graph[b[j]][b[i]];
					
				}
			}
			result = Math.min(result, Math.abs(temp1-temp2));
			// 이제 계산하기
			
			return;
		}
		for (int i = idx; i < n; i++) {
			a[cnt] = input[i]; 
			com(i+1,cnt+1);
		}
		
	}
}
