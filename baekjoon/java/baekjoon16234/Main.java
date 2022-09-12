package baekjoon16234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx ={0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n,l,r,graph[][],result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		l = Integer.parseInt(token.nextToken());
		r = Integer.parseInt(token.nextToken());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		//입력 완료
		for (int k = 0; k < 2001; k++) {
			boolean[][] visited = new boolean[n][n];
			boolean total_bool = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(visited[i][j] == false) {
						visited[i][j]=true;
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[] {i,j});
						ArrayList<int[]> visited_list = new ArrayList<>();
						visited_list.add(new int[] {i,j});
						boolean change_bool = bfs(graph[i][j],visited,q,visited_list);
						if(change_bool) {
							total_bool = true;
						}
					}
				}
			}
			if(total_bool) {
				result++;
			}
			else {
				break;
			}
		}
		System.out.println(result);
	}
	static boolean bfs(int sum,boolean[][] visited,Queue<int[]> queue,ArrayList<int[]> visited_list) {
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int y= xy[0];
			int x = xy[1];
			for (int i = 0; i < 4; i++) {
				int vy = y+dy[i];
				int vx = x+dx[i];
				if(-1<vy&& vy<n && -1<vx&& vx<n && visited[vy][vx]==false) {
					if (l<=Math.abs(graph[vy][vx]-graph[y][x]) && Math.abs(graph[vy][vx]-graph[y][x])<=r) {
						visited[vy][vx]=true;
						visited_list.add(new int[] {vy,vx});
						sum += graph[vy][vx];
						queue.add(new int[] {vy,vx});
					}
					
				}
			}
		}
		if(visited_list.size()>1) {
			int changed_value = sum/visited_list.size();
			for(int[] i : visited_list) {
				graph[i[0]][i[1]] = changed_value;
			}
			return true;
			
		}
		else {
			return false;
			
		}
		
	}

}
