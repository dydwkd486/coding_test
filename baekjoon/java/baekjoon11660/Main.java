package baekjoon11660;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		int[][] n_list = new int[n][n];
		int[][] m_list = new int[m][4];
		int[][] sum_list = new int[n+1][n+1];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				n_list[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				m_list[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		for (int i = 1; i <n+1; i++) {
			for (int j = 1; j <n+1; j++) {
				sum_list[i][j] = sum_list[i][j-1]+sum_list[i-1][j]-sum_list[i-1][j-1]+n_list[i-1][j-1];
			}
		}
//		for (int[] is : sum_list) {
//			for (int is2 : is) {
//				System.out.print(is2+" ");
//				
//			}
//			System.out.println();
//		}
		for (int[] x : m_list) {
			int result = sum_list[x[2]][x[3]]-sum_list[x[2]][x[1]-1]-sum_list[x[0]-1][x[3]]	+sum_list[x[0]-1][x[1]-1];
			sb.append(result).append('\n');
		}
		System.out.println(sb);
		
	}
}