package baekjoon14499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 함수 두개 만들기
// 그래프에서 위치 이동 => 완성
// 
// 주사위 움직이기
// 움직이고 값 바꾸기
public class Main {
	static int n,m,x,y,k,graph[][];
	static int cube[][] = new int[4][3];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		y = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken());
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int temp = Integer.parseInt(token.nextToken())-1;
			int vx = x+dx[temp];
			int vy = y+dy[temp];
			if(-1<vx && vx<m && -1<vy && vy<n) { // 지나 갈수 있는 경우에만 찍기
				x = vx;
				y = vy;
				cubeRotate(temp);
			}
			
			
		}
		
	} // end
	static void cubeRotate(int rotate) {
		// 이동후 바닥을 찍는다.
		// 1. 이동
		// 1-1 상하좌우 움직이는 것이 다름. 이동 방향 값 가져오디
		// 2. 찍기
		int bottom = cube[3][1]; // 바닥 부분
		int temp=0;
		if(rotate ==0) { // 동
			temp = cube[1][2];
			cube[1][2] = cube[1][1];
			cube[1][1] = cube[1][0];
			cube[1][0] = bottom;
		}
		else if (rotate ==1){ // 서
			temp = cube[1][0];
			cube[1][0] = cube[1][1];
			cube[1][1] = cube[1][2];
			cube[1][2] = bottom;
			
		}
		else if (rotate ==2){ // 북
			temp = cube[0][1];
			cube[0][1]=cube[1][1];
			cube[1][1]=cube[2][1];
			cube[2][1]=bottom;
			
		}
		else if (rotate ==3){ // 남
			temp = cube[2][1];
			cube[2][1]=cube[1][1];
			cube[1][1]=cube[0][1];
			cube[0][1]=bottom;
		}
		// 바닥부분 칠하기
		if(graph[y][x]!=0) {
			cube[3][1]= graph[y][x];
			graph[y][x]=0;
			
		}
		else {
			cube[3][1]= temp;
			graph[y][x]= temp;
			
		}
		
		// 그래프에 있는 값을 0으로 변경
		
		System.out.println(cube[1][1]);
	}

}
