package baekjoon11505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static long[] arr, tree;
	static int C, startIdx, Ntree;
	static long ans;

	static void update(int index, int num) {
		index = startIdx+index-1;
		tree[index] = num;
		index =index/2;
		while(index>0) {
			tree[index] = (tree[index*2]*tree[index*2+1])%1000000007;
			index= index/2;
		}
		
	}
	static void query(int start, int end) {
		start = start+startIdx -1;
		end = end+startIdx -1;
		while(start<=end) {
			if(start%2==1) {
				ans=(ans*tree[start])%1000000007;
			}
			if(end%2==0) {
				ans=(ans*tree[end])%1000000007;
			}
			start=(start+1)/2;
			end = (end-1)/2;
		}
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		C = (int)Math.ceil(Math.log(N)/Math.log(2));
		startIdx = (int)Math.pow(2, C);
		Ntree = (int)Math.pow(2, C+1);
		tree = new long[Ntree];
		Arrays.fill(tree, 1);
		
		for (int i = 1; i < N+1; i++) {
			int temp = Integer.parseInt(br.readLine());
			update(i,temp);
		}
		for (int i = 0; i < M+K; i++) {
			st= new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(c==1) {
				update(s, e);
			}
			else {
				ans = 1;
				query(s, e);
				sb.append(ans%1000000007).append("\n");
			}
		}
		System.out.println(sb);
		
		
	}
}
