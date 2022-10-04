package SW5656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T, N,W,H,graph[][],result= Integer.MAX_VALUE;
	static int[] dx = new int[] {0,1,-1,0};
	static int[] dy = new int[] {1,0,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			H = Integer.parseInt(token.nextToken());
			result= Integer.MAX_VALUE;
			graph = new int[H][W];
			for (int i = 0; i < H; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					graph[i][j] = Integer.parseInt(token.nextToken());
				}
			}	
			dfs(graph,0);
			System.out.println("#"+tc+" "+result);
			

		} // end tc
	} // end
	static void dfs(int graph[][],int count) {
		if(count==N) {
			//이제 카운트 확인하고 최대 많이 부쉬고 남은 최소 값을 만들기
//			print(graph);
			result = Math.min(result, countGraph(graph));
//			System.out.println(countGraph(graph));
			
			return;
		}
		else {
			for (int i = 0; i < W; i++) {
				dfs(broken(graph,i),count+1);
			}
		}
		
	}
	static int[][] broken(int g[][],int num) {
		int[][] graph = cloneGraph(g);
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < H; i++) {
			if(graph[i][num] == 0) continue;
			q.add(new int[] {i,num,graph[i][num]});
			graph[i][num]=0;
			break;
		}
		while(!q.isEmpty()) {
			int[] temp = q.pollLast();
			int y = temp[0];
			int x = temp[1];
			int z = temp[2]; // 주변 파괴
			for (int i = 0; i < 4; i++) {
				int vy = y;
				int vx = x;
				for (int j = 1; j < z; j++) { // z번 해야함!
					vy +=dy[i];
					vx +=dx[i];
					if(-1<vy && vy<H && -1<vx && vx<W) { // 안에 포함되는구만!
						if(graph[vy][vx]==0) continue;
						q.addFirst(new int[] {vy,vx,graph[vy][vx]});
						graph[vy][vx]=0;
					}
				}
			}
			
		}
		return stackGraph(graph);
	}
	static int[][] stackGraph(int g[][]) {
		int[][] graph = new int[H][W];
		int position = H-1;
		for (int i = 0; i < W; i++) {
			position=H-1;
			for (int j = H-1; j > -1; --j) {
				if(g[j][i]==0) continue;
				graph[position][i]=g[j][i];
				position--;
			}
		}
//		print(graph);
		return graph;
	}
	static int[][] cloneGraph(int graph[][]){
		int[][] clone = new int[H][W];
		for (int i = 0; i < clone.length; i++) {
			clone[i] = graph[i].clone();
		}
		return clone;
		
	}
	static void print(int graph[][]) {
		for (int[] is : graph) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
	static int countGraph(int graph[][]) {
		int count=0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if(graph[i][j]==0) continue;
				count++;
			}
		}
		return count;
	}
}
