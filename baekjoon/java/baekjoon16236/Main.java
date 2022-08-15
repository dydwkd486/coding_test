package baekjoon16236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 아기 상어
 * 1. 작은 물고기만 먹을수 있음.
 * 2. 같은 물고기는 먹을수 없지만 지나는 갈수 있음.
 * 3. 같은 크기의 물고기를 같은 수만큼 먹어야 커짐.
 * 
 * */
public class Main {
	static int[][] visited;
	static int shark_x;
	static int shark_y;
    static int dx[] = {-1, 0, 1, 0}; //위 왼 아래 오
    static int dy[] = {0, 1, 0, -1};
	static int sharkSize = 2;
	static int sharkSizeup = 0;
	static int result = 0;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			String input1[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(input1[j]);
				graph[i][j] = num;
				if(num==9) {
					shark_y=i;
					shark_x=j;
					graph[i][j]=0;
				}
			}
		}
		
		while(true) {
			
			Queue<int[]> queue = new LinkedList<int[]>();
			// 처음 초기화
			queue.offer(new int[] {shark_y,shark_x});
			visited = new int[n][n];
			visited[shark_y][shark_x] = 1;

			while(!queue.isEmpty()) {
				int[] v = queue.poll();
				for (int i = 0; i < 4; i++) {
					int sy=v[0]+dy[i];
					int sx=v[1]+dx[i];
					if(-1<sy && sy<n && -1<sx && sx<n) {
						if(visited[sy][sx]==0 && graph[sy][sx]<=sharkSize) {
							visited[sy][sx]=visited[v[0]][v[1]]+1;
							queue.offer(new int[] {sy,sx});
						}
					}
				}
			}
			
			int temp = Integer.MAX_VALUE;
			int temp_x = -1;
			int temp_y = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(graph[i][j]==0) continue;
					if(graph[i][j]>=sharkSize) continue;
					if(visited[i][j]==0)continue;
					if(temp>visited[i][j]) {
						temp =visited[i][j];
						temp_y = i;
						temp_x = j;
					}
				}
			}
			if(temp_x==-1) {
				break;
			}
			
			result += visited[temp_y][temp_x]-1;
			graph[temp_y][temp_x] = 0;
			sharkSizeup++;
			if(sharkSizeup==sharkSize) {
				sharkSize++;
				sharkSizeup =0;
			}
			shark_y = temp_y;
			shark_x = temp_x;
		
			
		}
		System.out.println(result);
	}

}
