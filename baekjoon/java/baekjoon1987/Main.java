package baekjoon1987;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int r,c;
	static char[][] graph;
	static int result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		r = Integer.parseInt(token[0]);
		c = Integer.parseInt(token[1]);
		graph=new char[r][c];
		for (int i = 0; i < r; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		dfs(0,0,1,1 << graph[0][0]-'A');
		
		System.out.println(result);
	}
	static void dfs(int x, int y,int count,int temp) {
		result = Math.max(result, count);
		for (int i = 0; i < 4; i++) {
			int vx = x+dx[i];
			int vy = y+dy[i];
			if(-1<vx && vx<c && -1<vy && vy<r) {
				if((temp & 1 << graph[vy][vx]-'A')==0) {
//					System.out.println(1 << graph[vy][vx]-'A');
					dfs(vx,vy,count+1,temp | 1 << graph[vy][vx]-'A');
				}
			}
		}
	}

}
