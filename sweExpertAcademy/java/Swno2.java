package no2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int t,n,graph[][],n_list[],start[],r,result;
	static boolean select[];
	static Map<Integer, int[]> xy = new HashMap<Integer, int[]>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			n_list = new int[8];
			r =0;
			result =Integer.MAX_VALUE;
			
			for (int i = 0; i < n; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j]=Integer.parseInt(token.nextToken());
					if(graph[i][j]!=0) {
						n_list[r]=graph[i][j];
						xy.put(graph[i][j], new int[] {i,j});
						r++;
					}
				}
			}
			start = new int[r];
			select = new boolean[r];
			
			per(0);
			System.out.println("#"+tc+" "+result);
		}// tc end
	} // main
	static void per(int cnt) {
		if(r==cnt) {
			int sum =0;
			int[] fXY = new int[] {0,0};
			int[] temp = new int[start.length/2];
			int tempCount = 0;
			for (int i = 0; i < start.length; i++) {
				if(start[i]<0) { //음수
					boolean a=false;
					for (int j = 0; j < temp.length; j++) {
						if(temp[j]==-start[i]) {
							a=true;
						}
					}
					if(a==false) {
						return;
					}
				}
				else { // 양수
					temp[tempCount++] = start[i];
				}
			}
			// 이제 가능한 것들만 나옴.
//			System.out.println(Arrays.toString(start));
			for (int i : start) {
				sum+=Math.abs(xy.get(i)[0]-fXY[0])+Math.abs(xy.get(i)[1]-fXY[1]);
				fXY = xy.get(i).clone();
			}
//			System.out.println(sum);
			result = Math.min(result, sum);
			return;
		}
		for (int i = 0; i < r; i++) {
			if(select[i]) continue;
			select[i] = true;
			start[cnt] = n_list[i];
			per(cnt+1);
			select[i] = false;
		}
	}
}
