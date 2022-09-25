package baekjoon13460;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n,m,result=Integer.MAX_VALUE;
	static String graph[][];
	static boolean checked[][][][];
	static int[] Rp= new int[2],Bp= new int[2],Op=new int[2];
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		n = Integer.parseInt(token[0]);
		m = Integer.parseInt(token[1]);
		graph = new String[n][m];
		checked = new boolean[n][m][n][m];
		for (int i = 0; i < n; i++) {
			token = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				graph[i][j] = token[j]; 
				if(graph[i][j].equals("R")) {
					Rp[0]= i;
					Rp[1]= j;
				}
				else if(graph[i][j].equals("B")) {
					Bp[0]= i;
					Bp[1]= j;
				}
			}
		}
//		for (String[] string : graph) {
//			System.out.println(Arrays.toString(string));
//		}
//		System.out.println();
		bfs(Rp,Bp,0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		
	}// end
	static void bfs(int[] Rp, int[] Bp, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {Rp[0],Rp[1],Bp[0],Bp[1], cnt});
		checked[Rp[0]][Rp[1]][Bp[0]][Bp[1]] =true;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int pCnt = pos[4];
			
			if(pCnt>=10) {
				return;
			}
			for(int i=0; i<4; i++){
				int nRx = pos[0];
				int nRy = pos[1];
				int nBx = pos[2];
				int nBy = pos[3];
				
				// 빨간 구슬 이동 
				while(!graph[nRx+dx[i]][nRy+dy[i]].equals("#")) {
					nRx += dx[i];
					nRy += dy[i];
					if(graph[nRx][nRy].equals("O")) break;
				}
				
				// 파란 구슬 이동
				while(!graph[nBx+dx[i]][nBy+dy[i]].equals("#")) {
					nBx += dx[i];
					nBy += dy[i];
					if(graph[nBx][nBy].equals("O")) break;
				}
				
				// 파란 구슬이 구멍에 들어갔을 때
				if(graph[nBx][nBy].equals("O")) continue;
				
				if(graph[nRx][nRy].equals("O")) {
					result = Math.min(result, pCnt+1);
					return;
				}
				
				// 빨간 파랑 서로 만났을 때 
				if(nRx == nBx && nRy == nBy && !graph[nRx][nRy].equals("O")) { 
					int red_move = Math.abs(nRx-pos[0]) + Math.abs(nRy-pos[1]);
					int blue_move = Math.abs(nBx-pos[2]) + Math.abs(nBy-pos[3]);
					
					// 파란 공이 더 빨리 도착한 경우  
					if(red_move > blue_move) {
						nRx -= dx[i];
						nRy -= dy[i];
					}else { // 빨간 공이 더 빨리 도착한 경우  
						nBx -= dx[i];
						nBy -= dy[i];
					}
				}
				
				if(!checked[nRx][nRy][nBx][nBy]) {
					checked[nRx][nRy][nBx][nBy] = true;
					q.add(new int[] {nRx, nRy, nBx, nBy, pCnt+1});
				}
			}
		}
		
	}
}
