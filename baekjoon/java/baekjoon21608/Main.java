package baekjoon21608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int[][] graph;
	static int n;
	static int[][] n_list;
	static int[] dx = {0,-1,1,0};
	static int[] dy = {-1,0,0,1};
	static int result = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		n_list = new int[n*n][5];
		graph = new int[n][n];
		for (int i = 0; i < n*n; i++) {
			String[] token = br.readLine().split(" ");
			for (int j = 0; j < token.length; j++) {
				n_list[i][j] = Integer.parseInt(token[j]);
			}
		}

		
		for (int i = 0; i < n*n; i++) {
			int[] temp = love(i);
//			System.out.println(temp[0]);
//			System.out.println(temp[1]);
			if(temp[0]==-1) {
				emp(n_list[0][0]);
			}
			else {
				graph[temp[0]][temp[1]] = n_list[i][0];
			}
			graph_print();
			
		}
		// 개수 확인하기
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				int temp = 0;
				for (int i = 0; i < 4; i++) {
					int vx = x+dx[i];
					int vy = y+dy[i];
					if(-1<vx && vx<n && -1<vy && vy<n) {
						for (int j = 1; j < 5; j++) {
							if(graph[vy][vx]==n_list[position(y,x)][j]) {
								temp++;
							}
						}
					}
				}
				if(temp==1) result+=1;
				else if(temp==2) result+=10;
				else if(temp==3) result+=100;
				else if(temp==4) result+=1000;
			}
		}
		System.out.println(result);
		
	}
	
	static void graph_print() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	} 
	
	static void emp(int count) {
		int temp=-1;
		int temp_x=-1;
		int temp_y=-1;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if(graph[y][x]!=0) continue;
				int temp_count=0;
				for (int i = 0; i < 4; i++) {
					int vx = x+dx[i];
					int vy = y+dy[i];
					if(-1<vx && vx<n && -1<vy && vy<n) {
						for (int j = 1; j < 5; j++) {
							if(graph[vy][vx]==0){
								temp_count++;
							}
						}
					}
				}
				if(temp<temp_count) {
					temp = temp_count;
					temp_x = x;
					temp_y = y;
				}
			}
		}
		graph[temp_y][temp_x]=count;
	}
	static int[] love(int count) {
		int temp=-1;
		int temp_emp=0;
		int temp_x=-1;
		int temp_y=-1;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if(graph[y][x]!=0) continue;
				int temp_count=0;
				int temp_emp_count =0;
				for (int i = 0; i < 4; i++) {
					int vx = x+dx[i];
					int vy = y+dy[i];
					if(-1<vx && vx<n && -1<vy && vy<n) {
						for (int j = 1; j < 5; j++) {
							if(graph[vy][vx]==n_list[count][j]){
								temp_count++;
							}
							if(graph[vy][vx]==0){
								temp_emp_count++;
							}
						}
					}
				}
				if(temp<temp_count) { // 1조건
					temp = temp_count;
					temp_emp = temp_emp_count;
					temp_x = x;
					temp_y = y;
				}
				if(temp==temp_count) { // 2조건
					if(temp_emp<temp_emp_count) {
						temp_emp = temp_emp_count;
						temp_x = x;
						temp_y = y;
					}
				}
			}
		}
		return new int[] {temp_y,temp_x};
	}
	static int position(int y,int x) {
		for (int i = 0; i < n_list.length; i++) {
			if(graph[y][x]==n_list[i][0]) return i;
		}
		return 0;
	}
}
