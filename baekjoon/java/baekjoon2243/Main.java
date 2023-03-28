package baekjoon2243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int N,K,Ntree,startIdx;
	static int answer;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static void query(int num) {
		int start = 1;
		while(start<startIdx) {
			if(tree[start*2]>=num) {
				start*=2;
				answer = start;
			}
			else {
				num -=tree[start*2];
				start=(start*2)+1;
				answer = start;
			}
			
		}
	}
	static void update(int index, int num) {
		index = startIdx+index-1;
		tree[index]+=num;
		index/=2;
		while(index>0) {
			tree[index] = tree[index*2]+tree[index*2+1];
			index/=2;
		}
	}
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		K = (int)Math.ceil(Math.log(1000000)/Math.log(2));
		startIdx = (int) Math.pow(2, K);
		Ntree = (int) Math.pow(2, K+1);
		tree = new long[Ntree];
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			if(temp==1) {
				answer =0;
				int num = Integer.parseInt(st.nextToken());
				query(num);
				update(answer-startIdx+1,-1);
				sb.append(answer-startIdx+1).append("\n");
//				System.out.println(answer-startIdx+1);
			}
			else if(temp==2){
				int index = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				update(index,num);
			}
		}
		System.out.println(sb);
		
	}
	

}
