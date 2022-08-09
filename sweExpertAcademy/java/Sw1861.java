import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int count;
	static int[] result;
	static int[][] graph;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			result = new int[2];
			for (int i = 0; i < graph.length; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < graph.length; j++) {
					graph[i][j] = Integer.parseInt(token.nextToken());
				}
			}
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph.length; j++) {
					count = 1;
					dfs(i,j,graph[i][j]);
					if(result[1] < count) {
						result[0]=graph[i][j];							
						result[1]=count;
					}
					else if(result[1] == count && result[0]>graph[i][j]) {
							result[0]=graph[i][j];							
					}
				}
			}
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(result[0]);
			sb.append(" ");
			sb.append(result[1]);
			sb.append("\n");
		} //tc end
		System.out.println(sb);
	}
	
	static void dfs(int i,int j,int sum) {
		for (int k = 0; k < 4; k++) {
			int kx = j+dx[k];
			int ky = i+dy[k];
			if(-1<kx && kx<n && -1<ky && ky<n) {
				if(graph[ky][kx]==(sum+1)) {
					count++;
					dfs(ky,kx,sum+1);
					break;
				}
				else if(count==1 && graph[ky][kx]==(sum-1)) {
					break;
				}
			}
			
		}
	}
}
