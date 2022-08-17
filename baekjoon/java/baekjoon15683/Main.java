package baekjoon15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int n,m;
	static int[][] graph; 
	static int[][] visited;
	static int result=Integer.MAX_VALUE;
	static ArrayList<String> nList = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		graph = new int[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
				if(0<graph[i][j] && graph[i][j]<6)
					nList.add(i+" "+j);
			}
		}
//		System.out.println(nList);
//		printGraph();
		rec(0);
//		printVisited();
		System.out.println(result);
		
	}
	static void rec(int idx) {
//		System.out.println(idx);
		if(nList.size()<=idx) {
//			printVisited();
			printsum();
			return;
			}
		int y = Integer.parseInt(nList.get(idx).split(" ")[0]);
		int x = Integer.parseInt(nList.get(idx).split(" ")[1]);
		if(graph[y][x]==1) {
			for (int i = 0; i < 4; i++) {
				int vx = x;
				int vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
				rec(idx+1);
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
			}
		}
		else if(graph[y][x]==2) {
			for (int i = 0; i < 2; i++) {
				int vx = x;
				int vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
				vx = x;
				vy = y;
				while(true) {
					vx -=dx[i];
					vy -=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
				rec(idx+1);
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
				vx = x;
				vy = y;
				while(true) {
					vx -=dx[i];
					vy -=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
				
			}
			
		}
		else if(graph[y][x]==3) {
			for (int i = 0; i < 4; i++) {
				int vx = x;
				int vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[(i+1)%4];
					vy +=dy[(i+1)%4];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
				rec(idx+1);
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[(i+1)%4];
					vy +=dy[(i+1)%4];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
			}
		}
		else if(graph[y][x]==4) {
			for (int i = 0; i < 4; i++) {
				int vx = x;
				int vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[(i+1)%4];
					vy +=dy[(i+1)%4];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[(i+2)%4];
					vy +=dy[(i+2)%4];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
				rec(idx+1);
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[(i+1)%4];
					vy +=dy[(i+1)%4];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
				vx = x;
				vy = y;
				while(true) {
					vx +=dx[(i+2)%4];
					vy +=dy[(i+2)%4];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
			}
		}
		else if(graph[y][x]==5) {
			for (int i = 0; i < 4; i++) {
				int vx = x;
				int vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=0) {
							continue;
						}
						visited[vy][vx] = idx+1;
					}
					else {
						break;
					}
				}
			}
			rec(idx+1);
			for (int i = 0; i < 4; i++) {
			int vx = x;
			int vy = y;
				while(true) {
					vx +=dx[i];
					vy +=dy[i];
					if(-1<vx && vx<m && -1<vy && vy<n) {
						if(graph[vy][vx]==6) {
							break;
						}
						else if(visited[vy][vx]!=idx+1) {
							continue;
						}
						visited[vy][vx] = 0;
					}
					else {
						break;
					}
				}
			}
		}
		
		
	}
	static void printsum() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(graph[i][j]==0&&visited[i][j]==0) {
					sum++;
				}
			}
		}
		result = Math.min(result, sum);
//		System.out.println(sum);
	}
	static void printGraph() {
		for (int[] is : graph) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
	static void printVisited() {
		for (int[] is : visited) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
}
