import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
//	static int[] n_list;
	static int result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] n_list= new int[n];
			boolean[] checked = new boolean[n];
            int max =0;
			result = 0;
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				n_list[i]= Integer.parseInt(token.nextToken());
				max+=n_list[i];
			}

			recursion(0,checked, 0,0,n_list,n,max);
			sb.append("#").append(tc).append(" ").append(result).append("\n");
//			System.out.println("#"+tc+" "+result);
		}
		System.out.println(sb);
	}
	static void recursion(int cnt,boolean[] checked,int rsum,int lsum , int[] n_list,int n,int max) {
		if(lsum >= rsum + max) {
			int idx = 1;
            for (int i = 0; i < n - cnt; i++)
            	idx *= 2;
            for (int i = 1; i <= n - cnt; i++)
            	idx *= i;
            result += idx;
			return;
			
		}
		if(cnt == n) {
			result++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!checked[i]) {
				checked[i] = true;
				if(rsum>=lsum+n_list[i])
					recursion(cnt+1, checked, rsum,lsum+n_list[i],n_list,n,max-n_list[i]);
				recursion(cnt+1,checked, rsum+n_list[i],lsum,n_list,n,max-n_list[i]);
				checked[i] = false;
			}
//			if((flag& 1<<i)!=0) continue;
			
			
		}
	}
}
