package baekjoon17144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r,c,t,graph[][];
	static int aircleaner;
	static int[] vx = {1,0,-1,0};
	static int[] vy = {0,1,0,-1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		r = Integer.parseInt(token.nextToken());
		c = Integer.parseInt(token.nextToken());
		t = Integer.parseInt(token.nextToken());
		graph = new int[r][c];
		for (int i = 0; i < r; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
				if(graph[i][j]==-1) aircleaner=i;
			}
		}
		for (int i = 0; i < t; i++) {
			diffusion();
			upwind();
			downwind();
		}
//		print(graph);
		System.out.println(sum());

	} // main end
	static void diffusion() {
		int[][] temp = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(graph[i][j]>0) { // 확산이 가능함.
					int value = graph[i][j];
					for (int k = 0; k < 4; k++) {
						int sx = j+vx[k];
						int sy = i+vy[k];
						if(-1<sx && sx<c && -1<sy && sy<r) {
							if(graph[sy][sx]==-1) continue;
							temp[sy][sx] += graph[i][j]/5;
							value -=graph[i][j]/5;
						}
					}
					temp[i][j]+=value;
				}
				if(graph[i][j]==-1) {
					temp[i][j]=-1;
				}
			}
		}
		graph= temp;
	}
	static void upwind() {
		int y = aircleaner;
		int x = 1;
		int temp1 =0;
		int temp2 =0;
		int num =0;
		
		while(true) {
			if(num==0) { // 오른쪽으로 전진;
				if(x+1<c) {
					temp1 = temp2;
					temp2 = graph[y-1][x];
					graph[y-1][x] = temp1;
					x++;
				}
				else {// 위쪽으로 이동하게 변경
					num++;
				}
			}else if(num==1) {
				if(y-1>0) {
					temp1 = temp2;
					temp2 = graph[y-1][x];
					graph[y-1][x] = temp1;
					y--;
				}
				else {// 왼쪽으로 이동하게 변경
					num++;
				}
			}else if(num==2) {
				if(x>0) {
					temp1 = temp2;
					temp2 = graph[y-1][x];
					graph[y-1][x] = temp1;
					x--;
				}
				else {// 왼쪽으로 이동하게 변경
					num++;
				}
			}else if(num==3) {
				if(y+1<aircleaner+1) {
					temp1 = temp2;
					temp2 = graph[y-1][x];
					graph[y-1][x] = temp1;
					y++;
				}
				else {// 위쪽으로 이동하게 변경
					num++;

				}
			}
			else {
				break;
			}
		}
	}
	static void downwind() {
		int y = aircleaner;
		int x = 1;
		int temp1 =0;
		int temp2 =0;
		int num =0;
		
		while(true) {
			if(num==0) { // 오른쪽으로 전진;
				if(x+1<c) {
					temp1 = temp2;
					temp2 = graph[y][x];
					graph[y][x] = temp1;
					x++;
				}
				else {// 위쪽으로 이동하게 변경
					num++;
				}
			}else if(num==1) {
				if(y+1<r) {
					temp1 = temp2;
					temp2 = graph[y][x];
					graph[y][x] = temp1;
					y++;
				}
				else {// 왼쪽으로 이동하게 변경
					num++;
				}
			}else if(num==2) {
				if(x>0) {
					temp1 = temp2;
					temp2 = graph[y][x];
					graph[y][x] = temp1;
					x--;
				}
				else {// 왼쪽으로 이동하게 변경
					num++;
				}
			}else if(num==3) {
				if(y>aircleaner) {
					temp1 = temp2;
					temp2 = graph[y][x];
					graph[y][x] = temp1;
					y--;
				}
				else {// 위쪽으로 이동하게 변경
					num++;

				}
			}
			else {
				break;
			}
		}
	}
	static int sum() {
		int sum =2;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum+=graph[i][j];
			}
		}
		return sum;
	}
	static void print(int[][] graph) {
		for (int[] is : graph) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
}
