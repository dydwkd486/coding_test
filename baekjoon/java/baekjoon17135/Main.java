package baekjoon17135;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m,d,x,y;
	static int[][] graph;
	static int sum;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		d = Integer.parseInt(token.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j]= Integer.parseInt(token.nextToken());
			}
		}
		// 입력 완료
		// 3개의 조합 만들기
		for (int i = 0; i < m-2; i++) {
			for (int j = i+1; j < m-1; j++) {
				for (int k = j+1; k < m; k++) {
//					System.out.println(i+":"+j+":"+k);
					stage(i,j,k);
				}
			}
		}

		System.out.println(result);
	}
	// 한번 실행 하는 공간 만들기
	static void stage(int a,int b,int c) {
		sum=0;
		int[][] temp = new int[n][m]; //깊은 복사!
		for (int i = 0; i < temp.length; i++) {
			temp[i] = graph[i].clone();
		}
		int[] x_list = new int[3];
		int[] y_list = new int[3];
		for (int tc = 0; tc < n; tc++) {
//			print(graph);
			attack(a);
			if(x==-1) {
				x_list[0] = -1;
				y_list[0] = -1;
			}
			else {
				x_list[0] = x;
				y_list[0] = y;
			}
			attack(b);
			if(x==-1) {
				x_list[1] = -1;
				y_list[1] = -1;
			}
			else {
				x_list[1] = x;
				y_list[1] = y;
			}
			attack(c);
			if(x==-1) {
				x_list[2] = -1;
				y_list[2] = -1;
			}
			else {
				x_list[2] = x;
				y_list[2] = y;
			}
			for (int i = 0; i < x_list.length; i++) {
				if(x_list[i]==-1) continue;
				if(graph[y_list[i]][x_list[i]]==0) continue;
				graph[y_list[i]][x_list[i]] = 0;
				sum++;					

			}
//			print(graph);
			move();
//			System.out.println(sum);
			
		}
//		System.out.println(sum);
		result = Math.max(result, sum);
		
		for (int i = 0; i < temp.length; i++) {
			graph[i] = temp[i].clone();
		}
		
	}
	// 적 한칸씩 움직이는 함수
	static void move() {
		for (int i = n-2; i > -1; i--) {
			for (int j = 0; j < m; j++) {
				graph[i+1][j]=graph[i][j];
			}
		}
		//맨 윗줄
		for (int j = 0; j < graph[0].length; j++) {
			graph[0][j]=0;
		}
		
	}
	// 왼쪽에서 부터 거리 계산해버려
	static void attack(int user) {
		int min = Integer.MAX_VALUE;
		x = -1;
		y = -1;
		for (int j = 0; j < m; j++) {
			for (int i = n-1; i > -1; i--) {
				if(graph[i][j]==0) continue;
				int degree = Math.abs(n-i)+Math.abs(j-user);
				if(degree>d) continue;
				if(min>degree) {
					min= degree;
					y=i;
					x=j;
//					System.out.println(degree);
//					System.out.println(i+":"+j);
				}
//				System.out.println(graph[i][j]);
			}
		}
		
	}
	static void print(int[][] graph) {
		for (int[] is : graph) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
}
