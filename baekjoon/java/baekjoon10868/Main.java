package baekjoon10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree, arr;
	static int N,M;
	static int K,startIdx,treeN;
	static int start, end;
	static long min;
	static void query(int start, int end) {
		start = startIdx+ start-1;
		end = startIdx+ end-1;
		while(start<=end) {
			if(start%2==1) {
				min = Math.min(tree[start], min);
			}
			if(end%2==0) {
				min = Math.min(tree[end], min);
			}
			start =(start+1)/2;
			end =(end-1)/2;
		}
		
	}
	static void update(int index, int num) {
		index = startIdx+index-1;
		tree[index] = num;
		index = index/2;
		while(index>0) {
			tree[index] = Math.min(tree[index*2], tree[index*2+1]);
			index /= 2;
		}
	}
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		K = (int) Math.ceil(Math.log(N)/Math.log(2));
		startIdx = (int) Math.pow(2, K);
		treeN = (int) Math.pow(2, K+1);
		tree = new long[treeN];
		
		for (int i = 1; i < N+1; i++) {
			int num = Integer.parseInt(br.readLine());
			update(i,num);
		}
		for (int i = 0; i < M; i++) {
			min = Long.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			query(s, e);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
		
	}
}
