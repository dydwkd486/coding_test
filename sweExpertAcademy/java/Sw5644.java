import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx= {0,0,1,0,-1}; // 상 우 하 좌
	static int[] dy= {0,-1,0,1,0};
	static Table[][] graph = new Table[11][11];
	static int m,a;
	static int[][] user;
	static int[][] bc;
	static int result ;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			result =0;
			token = new StringTokenizer(br.readLine());
			m = Integer.parseInt(token.nextToken());
			a = Integer.parseInt(token.nextToken());
			user = new int[2][m+1];
			bc = new int[a][4];
			// 이동 거리 추가
			user[0][0] =0;
			user[1][0] =0;
			for (int i = 0; i < 2; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 1; j < m+1; j++) {
					user[i][j] = Integer.parseInt(token.nextToken());	
				}
			}
			// BC 추가
			for (int i = 0; i < a; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					bc[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					graph[i][j]= new Table();
				}
			}
			// 그래프에 BC 칠하기
			for (int i = 0; i < a; i++) {
				int x = bc[i][0];
				int y = bc[i][1];
				int c = bc[i][2];
				int p = bc[i][3];
				for (int j = 0; j < c; j++) {
					int vy = y-c+j;
					if(vy>10 || vy<1) continue;
					for (int k = 0; k < (j*2+1); k++) {
						int vx = x-j+k;
						if(vx>10 || vx<1) continue;
						graph[vy][vx].setPerformance(p);
						graph[vy][vx].setCoverage(i);
					}
				}
				for (int j = c; j >-1 ; j--) {
					int vy =y-j+c;
					if(vy>10 || vy<1) continue;
					for (int k = 0; k < (j*2+1); k++) {
						int vx = x-j+k;
						if(vx>10 || vx<1) continue;
						graph[vy][vx].setPerformance(p);
						graph[vy][vx].setCoverage(i);
					}
				}
			}
//			printGraph();
			// 이동
			move();
			System.out.println("#"+tc+" "+result);
		}
	}
	static void move() {
		int aX =1;
		int aY =1;
		int bX =10;
		int bY =10;
		
		for (int i = 0; i <= m; i++) {
			aX += dx[user[0][i]];
			aY += dy[user[0][i]];
			bX += dx[user[1][i]];
			bY += dy[user[1][i]];
			if(graph[aY][aX].count==0 || graph[bY][bX].count==0) { 
				int tempA=0;
				int tempB=0;
				for (int j = 0; j < graph[aY][aX].performance.size(); j++) {
					if ( tempA<graph[aY][aX].performance.get(j)) {
						tempA=graph[aY][aX].performance.get(j);
					}					
				}
				for (int j = 0; j < graph[bY][bX].performance.size(); j++) {
					if ( tempB<graph[bY][bX].performance.get(j)) {
						tempB=graph[bY][bX].performance.get(j);
					}					
				}
				result += tempA+tempB;
				
			}
			else {
				int tempSum=0;
				for (int i1=0;i1<graph[aY][aX].coverage.size();i1++) {
					for (int i2=0;i2<graph[bY][bX].coverage.size();i2++) {
						// 겹치지 않음.
						if(graph[aY][aX].coverage.get(i1) != graph[bY][bX].coverage.get(i2)) {
							if(tempSum<graph[aY][aX].performance.get(i1)+graph[bY][bX].performance.get(i2)) {
								tempSum = graph[aY][aX].performance.get(i1)+graph[bY][bX].performance.get(i2);
							}
						}
						else {
							if(tempSum<graph[aY][aX].performance.get(i1)/2+graph[bY][bX].performance.get(i2)/2) {
								tempSum = graph[aY][aX].performance.get(i1)/2+graph[bY][bX].performance.get(i2)/2;
							}
						}
					}
				}
				result += tempSum;
			}
		}
		
	}
	static class Table{
		int count;
		ArrayList<Integer> coverage = new ArrayList<>();
		ArrayList<Integer> performance = new ArrayList<>();
		public Table() {
			// TODO Auto-generated constructor stub
		}
		public void setPerformance(int performance) {
			this.performance.add(performance);
			count++;
		}
		public void setCoverage(int coverage) {
			this.coverage.add(coverage);
		}

	}
	static void printGraph() {
		for (Table[] i : graph) {
			for (Table table : i) {
				System.out.print(table.performance+" ");
			}
			System.out.println();
		}
	}
}
