package baekjoon17069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][][] map = new long[N][N][4];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		map[0][1][1] = 1;
		for(int i=0;i<N;i++) {
			for(int j=1;j<N;j++) {
				if(j+1<N && map[i][j+1][0] == 0)
					map[i][j+1][1] += map[i][j][1];
				if(i+1<N && j+1<N && map[i][j+1][0] == 0 && map[i+1][j][0] == 0 && map[i+1][j+1][0] == 0)
					map[i+1][j+1][3] += map[i][j][1];
				if(i+1<N && map[i+1][j][0] == 0)
					map[i+1][j][2] += map[i][j][2];
				if(i+1<N && j+1<N && map[i][j+1][0] == 0 && map[i+1][j][0] == 0 && map[i+1][j+1][0] == 0)
					map[i+1][j+1][3] += map[i][j][2];
				if(j+1<N && map[i][j+1][0] == 0)
					map[i][j+1][1] += map[i][j][3];
				if(i+1<N && map[i+1][j][0] == 0)
					map[i+1][j][2] += map[i][j][3];
				if(i+1<N && j+1<N && map[i][j+1][0] == 0 && map[i+1][j][0] == 0 && map[i+1][j+1][0] == 0)
					map[i+1][j+1][3] += map[i][j][3];
			}
		}
		System.out.println(map[N-1][N-1][1]+map[N-1][N-1][2]+map[N-1][N-1][3]);
		br.close();
	}
}
