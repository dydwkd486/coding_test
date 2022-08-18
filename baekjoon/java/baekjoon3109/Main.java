package baekjoon3109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dx= {1,1,1};
	static int[] dy= {-1,0,1};
	static int r,c;
	static char[][] graph;
	static int result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		r = Integer.parseInt(token[0]);
		c = Integer.parseInt(token[1]);
		graph = new char[r][c];
		for (int i = 0; i < r; i++) {
			graph[i] = br.readLine().toCharArray();
		}
//		printGraph();
		for (int i = 0; i < r; i++) {
//			System.out.println(i);
				if(dfs(i,0)) {
//					printVisit();
					result++;
			}
			
		}
		System.out.println(result);
	}
	static boolean dfs(int y, int x) {
		// 끝까지 다 돌린경우와 막혀서 못가는 경우를 생각해야할듯. -> 갈곳이 없는 경우
		
		for (int i = 0; i < 3; i++) {
			int vx = x+dx[i];
			int vy = y+dy[i];
			if(vx<c && -1<vx && vy<r && -1<vy) { // 그래프 안에 존재
				if(graph[vy][vx]=='.') {
					graph[vy][vx]='-';
					if(vx == c-1) {
						return true;
					}
					if(dfs(vy,vx)) {				
						return true;
					}
				}
			}
		}	
		return false;
	}
	
	static void printGraph() {
		for (char[] i : graph) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}

}
