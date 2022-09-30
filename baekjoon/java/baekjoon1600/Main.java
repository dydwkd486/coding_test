package baekjoon1600;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int k,w,h,graph[][],selected[][][],n_list[][],result=Integer.MAX_VALUE;
	static ArrayDeque<int[]> queue;
	static int[] dx = {2,2,-2,-2,1,1,-1,-1};
	static int[] dy = {1,-1,1,-1,2,-2,-2,2};
	static int[] sy = {1,-1,0,0};
	static int[] sx = {0,0,1,-1};
	public static class Node {
		int x;
		int y;
		int count;
		int k;
		
		public Node(int x, int y, int count, int k) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.k = k;
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		k = Integer.parseInt(br.readLine());
		token= new StringTokenizer(br.readLine());
		w = Integer.parseInt(token.nextToken());
		h = Integer.parseInt(token.nextToken());
		
		graph = new int[h][w];
		for (int i = 0; i < h; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		// 입력 완료
		
		selected = new int[h][w][k+1];
		result =bfs(0,0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
		
	} // end
	static int bfs(int x, int y) {
		ArrayDeque<Node> q = new ArrayDeque<>();
		q.addFirst(new Node(x, y, 0, k));
		selected[y][x][k] = 1;
		while(!q.isEmpty()) {
			Node current = q.pollLast();
			if(current.y == h-1 && current.x == w-1) return current.count;
			for (int i = 0; i < 4; i++) {
				int nx = current.x+sx[i];
				int ny = current.y+sy[i];
				if(nx<w && nx>-1 && ny<h && ny>-1) {
					if(selected[ny][nx][current.k]==0 && graph[ny][nx]==0) {
						selected[ny][nx][current.k]=1;
						q.addFirst(new Node(nx,ny,current.count+1,current.k));
					}
				}
			}
			if(current.k>0) {
				for (Node node : q) {
					
				}
				for (int i = 0; i < 8; i++) {
					int nx = current.x+dx[i];
					int ny = current.y+dy[i];
					if(nx<w && nx>-1 && ny<h && ny>-1) {
						if(selected[ny][nx][current.k-1]==0 && graph[ny][nx]==0) {
							selected[ny][nx][current.k-1]=1;
							q.addFirst(new Node(nx,ny,current.count+1,current.k-1));
						}
					}
				}			
			}
		}
		return result;
		
	}
}
