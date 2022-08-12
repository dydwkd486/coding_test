package baekjoon15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int m;
	static int n;
	static ArrayList<int[]> homes;
	static ArrayList<int[]> chickens;
	static int[][] temps;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		temps = new int[m][];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(token.nextToken());
				if(temp==1) {
					homes.add(new int[] {i,j});
				}
				if(temp==2) {
					chickens.add(new int[] {i,j});
				}
			}
		}
		combination(0, 0);
		System.out.println(result);
		
		
	}
	static void combination(int idx, int cnt) {
		if(cnt==m) {
			int min_count = 0;
			for (int[] home : homes) {
				int count =Integer.MAX_VALUE;
				for (int[] temp : temps) {
					count = Math.min(count, Math.abs(temp[0]-home[0])+Math.abs(temp[1]-home[1]));
				}
				min_count+=count;
			}
			result= Math.min(result, min_count);
			return;
		}
		for (int i = idx; i < chickens.size(); i++) {
			temps[cnt] = chickens.get(i);
			combination(i+1, cnt+1);
		}
	}

}
