package BJ16926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int r = Integer.parseInt(token.nextToken());
		
		int[][] graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		// 일단 집어 넣기 끝
		
		for(int count = 0; count<Math.min(n, m)/2 ; count++) { // 안으로 들어가면서 계산!
			Queue<Integer> temp = new ArrayDeque<>();
			for (int i = count; i < m-count; i++) { // 위 
				temp.offer(graph[count][i]);
			}
			for (int i = count+1; i < n-count; i++) { //오른쪽
				temp.offer(graph[i][m-1-count]);
			}
			for (int i = count+1; i < m-count; i++) { // 아래
				temp.offer(graph[n-1-count][m-1-i]);
			}		
			for (int i = count+1; i < n-count-1; i++) { // 왼쪽
				temp.offer(graph[n-1-i][count]);
			}
			
			
			for (int i = 0; i < r%temp.size(); i++) { // 회전회오리!
				temp.offer(temp.poll());
			}
			
			for (int i = count; i < m-count; i++) {
				graph[count][i] = temp.poll();
			}
			for (int i = count+1; i < n-count; i++) {
				graph[i][m-1-count] = temp.poll();
			}
			for (int i = count+1; i < m-count; i++) {
				graph[n-1-count][m-1-i] = temp.poll();
			}		
			for (int i = count+1; i < n-count-1; i++) {
				graph[n-1-i][count] = temp.poll();
			}
			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(graph[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
