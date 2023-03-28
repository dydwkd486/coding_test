package baekjoon1275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int N, Q, Ntree, startIdx, K;
	static long ans;
	static void update(int index,int num) {
		index = startIdx+index -1;
		tree[index] = num;
		index = index/2;
		while(index>0) {
			tree[index] = tree[index*2]+tree[index*2+1];
			index = index/2; 
		}
		
	}
	static void query(int start, int end) {
		start = start+startIdx -1;
		end = end+startIdx -1;
		while(start<=end) {
			if(start%2==1) {
				ans +=tree[start];
			}
			if(end%2==0) {
				ans +=tree[end];
			}
			start = (start+1)/2;
			end = (end-1)/2;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		K = (int) Math.ceil(Math.log(N)/Math.log(2));
		startIdx = (int) Math.pow(2, K);
		Ntree = (int) Math.pow(2, K+1);
		tree = new long[Ntree];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			update(i,temp);
		}
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			ans = 0;
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			query(Math.min(x, y), Math.max(x, y));
//			System.out.println(Arrays.toString(tree));
			sb.append(ans).append("\n");
			update(a, b);
			
		}
		System.out.println(sb);
	}

}
