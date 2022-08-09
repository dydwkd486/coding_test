import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken()), m= Integer.parseInt(token.nextToken()), b = Integer.parseInt(token.nextToken());
		int[][] graph = new int[n][m];
		int[] result = new int[2];
		result[0]= Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		for (int i = 0; i <= 256; i++) {
			int temp_b=b;
			int count = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < m; x++) {
					if(graph[y][x]>i) {
						temp_b+= graph[y][x]-i;
						count += (graph[y][x]-i)*2;
					}
					else if(graph[y][x]<i){
						temp_b-=i-graph[y][x];
						count += i-graph[y][x];
					}
				}
			}
			if(temp_b>=0) {
				if(count<result[0]) {
					result[0]=count;
					result[1]=i;
				}
				else if(count==result[0]) {
					if(i>result[1]) {
						result[1]=i;
					}
				}
			}
			
		}
		System.out.println(result[0]+" "+result[1]);				
	}
}
