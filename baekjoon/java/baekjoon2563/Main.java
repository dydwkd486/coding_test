import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int[][] graph = new int[101][101];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					graph[j][k]=1;
				}
			}
		}
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				count +=graph[i][j];
			}
		}
		System.out.println(count);
	}
}
