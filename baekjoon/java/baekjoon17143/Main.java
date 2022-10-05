package baekjoon17143;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int result, r,c,m;
	static Shark[][] shark;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// 낚시 하는 사람이 이동하면서 한개씩 잡아감 -> 이때 무게를 카운트
		// 상어 움직이게 하기 -> 속도에 맞춰 이동
		// 같은 위치의 경우 큰게 먹힘
		// 0~c 로 계산, 상어 위치-1씩해서 변경
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token  = new StringTokenizer(br.readLine());
		r = Integer.parseInt(token.nextToken()); // 높이
		c = Integer.parseInt(token.nextToken()); // 너비
		m = Integer.parseInt(token.nextToken());
		shark = new Shark[r][c];
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(token.nextToken())-1;
			int c= Integer.parseInt(token.nextToken())-1;
			int s= Integer.parseInt(token.nextToken());
			int d= Integer.parseInt(token.nextToken())-1;
			int z= Integer.parseInt(token.nextToken());
			shark[r][c] = new Shark(r,c,s, d, z);
		}
		for (int i = 0; i < c; i++) {
			// 여기서 상어 잡어 가기
			for (int j = 0; j < r; j++) {
				if(shark[j][i]==null) continue;
				result +=shark[j][i].z;
				shark[j][i] = null;
				break;
			}
			// 잡고 나면 상어 이동 시키기
			sharkMove();

		}
		System.out.println(result);


	}
	static void sharkMove() {
		Shark temp[][] = new Shark[r][c];
		for (int i = 0; i < shark.length; i++) {
			for (int j = 0; j < shark[0].length; j++) {
				if(shark[i][j]==null) continue;
				
				for (int k = 0; k < shark[i][j].s; k++) {
					int nr = shark[i][j].r +dy[shark[i][j].d];
					int nc = shark[i][j].c +dx[shark[i][j].d];
					if(-1<nr && nr<r && -1<nc && nc<c) {
						shark[i][j].r = nr;
						shark[i][j].c = nc;
					}
					else {
						if(shark[i][j].d%2==0) {
							shark[i][j].d++;
						}
						else {
							shark[i][j].d--;
						}
						k--;
					}
				}
				if(temp[shark[i][j].r][shark[i][j].c]==null) {
					temp[shark[i][j].r][shark[i][j].c] = shark[i][j];					
				}
				else {
					if(temp[shark[i][j].r][shark[i][j].c].z<shark[i][j].z) {
						temp[shark[i][j].r][shark[i][j].c] = shark[i][j];
					}
				}
			}
		}

		shark = temp;
		// 임의로 상어가 있는 곳곳에 상어 이동 시키기
		// 움직이는거 좌우 상하 고려하기
		// 이동 후에 null인 경우 그냥 이동 시키기
		// 이동 했는데 그 위치에 상어가 있으면 크기 비교하기
	}
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		boolean safe=true;
		
		public Shark(int r,int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}

}
