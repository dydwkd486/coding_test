package baekjoon14502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m,graph[][],result;
	static ArrayList<int[]> empList = new ArrayList<>();
	static ArrayList<int[]> virusList = new ArrayList<>();
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 벽 세우기
		// bfs로 바이러스 이동시키기 
		// 0인 개수 세기 -> 최대값을 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
				if(graph[i][j]==0) {
					empList.add(new int[] {i,j});
				}
				if(graph[i][j]==2) {
					virusList.add(new int[] {i,j});
				}
			}
		}
		wallCreate(0,0,new int[3]);
		System.out.println(result);
	}
	static void wallCreate(int count,int start, int[] temp) {
		if(count==3) {
			for (int i = 0; i < 3; i++) {
				int y = empList.get(temp[i])[0];
				int x = empList.get(temp[i])[1];
				graph[y][x]=1;
			}
			// 여기 bfs
			bfs(graph);
//			for (int[] i : graph) {
//				System.out.println(Arrays.toString(i));
//			}
//			System.out.println();
			for (int i = 0; i < 3; i++) {
				int y = empList.get(temp[i])[0];
				int x = empList.get(temp[i])[1];
				graph[y][x]=0;
			}
//			System.exit(0);
			return;
		}
		else {
			for (int i = start; i < empList.size(); i++) {
				temp[count]=i;
				wallCreate(count+1, i+1, temp);
				temp[count]=0;
				
			}
		}
		
	}
	static void bfs(int[][] g) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int[][] graph = new int[n][m];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = g[i].clone();
		}
		for (int[] i : virusList) {
			q.addFirst(i);
		}
		while(!q.isEmpty()) {
			int[] temp = q.pollLast();
			int y = temp[0];
			int x = temp[1];
			for (int i = 0; i < 4; i++) {
				int vy = y+dy[i];
				int vx = x+dx[i];
				if(-1<vy && vy<n && -1<vx && vx<m) {
					if(graph[vy][vx]==0) {
						graph[vy][vx]=2;
						q.addFirst(new int[] {vy,vx});
					}
				}
			}
		}
		count(graph);

	}// end
	static void count(int[][] g) {
		int count =0;
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[0].length; j++) {
				if(g[i][j]==0) {
					count++;
				}
			}
		}
		result = Math.max(result, count);
	}

}
