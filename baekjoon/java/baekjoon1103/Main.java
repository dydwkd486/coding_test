package baekjoon1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// baekjoon 1103 게임
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] nx = new int[] { -1, 1, 0, 0 };
	static int[] ny = new int[] { 0, 0, -1, 1 };
	static int answer = -1;
	static int r;
	static int c;
	static Character[][] graph;
	static boolean[][] visited;
	static int[][] dp;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		// 첫 위치

		// 그래프 만들기
		graph = new Character[r][c];
		visited = new boolean[r][c];
		dp = new int[r][c];

//		// 첫 위치는 방문 한걸로 처리
		visited[0][0] = true;

		for (int i = 0; i < r; i++) {
			String temp = br.readLine();
			for (int j = 0; j < c; j++) {
				graph[i][j] = temp.charAt(j);
			}
		}
		dfs(0, 0, 1);
		if(flag) System.out.println(-1);
		else System.out.println(answer);

	}

	public static void dfs(int y, int x, int count) {
		if (count > answer)
			answer = count;
		dp[x][y] = count;
		int mut = Integer.parseInt(graph[x][y].toString());

		for (int k = 0; k < 4; k++) {
			int dx = x + nx[k] * mut;
			int dy = y + ny[k] * mut;
			if (!(0 <= dx && dx < r && 0 <= dy && dy < c && graph[dx][dy] != 'H')) {
				continue;
			}
			if(visited[dx][dy]) {
				flag=true;
				return;
			}
			if(dp[dx][dy]>count) continue;
			visited[dx][dy] = true;
			dfs(dy,dx,count+1);
			visited[dx][dy] = false;
			

		}
	}

}
