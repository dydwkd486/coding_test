import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] br_list = br.readLine().split(" ");
		int n = Integer.parseInt(br_list[0]);
		int m = Integer.parseInt(br_list[1]);
		
		int[][] result = new int[n][m];
		
		for(int i =0;i<n;i++) {
			br_list = br.readLine().split(" ");	
			for(int j=0;j<br_list.length;j++) {
				result[i][j]=Integer.parseInt(br_list[j]);
			}
		}
		for(int i =0;i<n;i++) {
			br_list = br.readLine().split(" ");	
			for(int j=0;j<br_list.length;j++) {
				result[i][j]+=Integer.parseInt(br_list[j]);
			}
		}
		for(int i =0;i<n;i++) {	
			for(int j=0;j<m;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
