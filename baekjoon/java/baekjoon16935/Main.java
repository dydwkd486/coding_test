package BJ16935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,1,1,0};
	static int[] dy = {0,0,1,1};
	static int n;
	static int m;
	static int[][] graph;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		int r = Integer.parseInt(token.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j]= Integer.parseInt(token.nextToken());
			}
		}
		token= new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			// 여기서 실행!!
			change(Integer.parseInt(token.nextToken()));
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(graph[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void change(int idx) {
		
		if(idx == 4 || idx == 3) {
			int temp = n;
			n = m;
			m = temp;
		}
		int[][] temp = new int[n][m];
		switch (idx) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp[i]= graph[n-1-i];
				}
			}
			break;
		case 2:
			for (int j = 0; j < m; j++) {
				for (int i = 0; i < n; i++) {
					temp[i][j]= graph[i][m-1-j];
				}
			}
			break;
		case 3:
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < m; i++) {
					temp[j][i]= graph[m-1-i][j];
				}
			}
			break;
		case 4:
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < m; i++) {
					temp[j][i]= graph[i][n-1-j];
				}
			}
			break;
		case 5:
			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < n/2; i++) {
					for (int j = 0; j < m/2; j++) {
						temp[i+(n/2)*dy[(k+1)%4]][j+(m/2)*dx[(k+1)%4]] = graph[i+(n/2)*dy[k]][j+(m/2)*dx[k]];
					}					
				}
			}
			break;
		case 6:
			for (int k = 0; k < 4; k++) {
				for (int i = 0; i < n/2; i++) {
					for (int j = 0; j < m/2; j++) {
						temp[i+(n/2)*dy[k]][j+(m/2)*dx[k]] = graph[i+(n/2)*dy[(k+1)%4]][j+(m/2)*dx[(k+1)%4]];
					}				
				}
			}
			break;
		}
		graph = temp;
	}
	

}
