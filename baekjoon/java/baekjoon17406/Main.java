package BJ17406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static boolean[] visited;
	static String[] stringK;
	static int result = Integer.MAX_VALUE;
	static int k;
	static int n;
	static int m;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		graph = new int[n][m];
		stringK = new String[k];
		visited = new boolean[k];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j]= Integer.parseInt(token.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			stringK[i] = br.readLine(); 
		}	
		dfs(0);
		System.out.println(result);

	} // main end
	
	static void dfs(int count) {
		if(count==k) {
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum+=graph[i][j];
				}
				result = Math.min(sum, result);
			}
		}
		for (int i = 0; i < k; i++) {
			if(!visited[i]) {
				int r = Integer.parseInt(stringK[i].split(" ")[0]);
				int c = Integer.parseInt(stringK[i].split(" ")[1]);
				int s = Integer.parseInt(stringK[i].split(" ")[2]);
				visited[i]=true;
				rotate(r,c,s,true);
				dfs(count+1);
				rotate(r,c,s,false);
				visited[i]=false;
			}
		}
		
	}
	
	static void rotate(int r, int c, int s,boolean reversed) {
		int x1 = c-s-1;
		int y1 = r-s-1;
		int x2 = c+s-1;
		int y2 = r+s-1;
		int n = Math.abs(y2-y1)+1;
		int m = Math.abs(x2-x1)+1;
		for(int count = 0; count<Math.min(n, m)/2 ; count++) { // 안으로 들어가면서 계산!
			Deque<Integer> temp = new ArrayDeque<>();
			for (int i = count; i < n-count; i++) { // 왼쪽
				temp.offer(graph[y1+i][x1+count]);
			}
			for (int i = count+1; i < m-count; i++) { // 아래
				temp.offer(graph[y1+n-1-count][x1+i]);
			}
			for (int i = count+1; i < n-count; i++) { //오른쪽
				temp.offer(graph[y1+n-1-i][x1+m-1-count]);
			}
			for (int i = count+1; i < m-count-1; i++) { // 위 
				temp.offer(graph[y1+count][x1+m-1-i]);
			}

			
			if(reversed) {
				temp.offer(temp.poll());
			}
			else {
				temp.offerFirst(temp.pollLast());
			}
			
			
			for (int i = count; i < n-count; i++) {
				graph[y1+i][x1+count] = temp.poll();
			}
			for (int i = count+1; i < m-count; i++) {
				graph[y1+n-1-count][x1+i] = temp.poll();
			}
			for (int i = count+1; i < n-count; i++) {
				graph[y1+n-1-i][x1+m-1-count] = temp.poll();
			}		
			for (int i = count+1; i < m-count-1; i++) {
				graph[y1+count][x1+m-1-i] = temp.poll();
			}
			
		}

	}
}
