import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int t, n,n_list[],dp[];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token ;
		t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			int start =0;
			n_list = new int[n];
			dp = new int[n];
			
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				n_list[i] = Integer.parseInt(token.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				int idx = binarySearch(n_list[i],0,start,start+1);
				if(idx==-1) dp[start++]=n_list[i];
				else dp[idx] = n_list[i];
			}
			
			System.out.println("#"+tc+" "+start);
		}

		

	}
	static int binarySearch(int num,int start,int end,int size) {
		int res =0;
		while(start<=end) {
			int mid = (start+end)/2;
			if(num <=dp[mid]) {
				res = mid;
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		if(start == size) {
			return -1;
		}
		else {
			return res;
		}		
	}
}
