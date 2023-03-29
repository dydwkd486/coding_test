package baekjoon7578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	// baekjoon7578
	static int[] tree,arr;
	static int K,N,Ntree,startIdx;
	static long count;
	static void query(int start, int end) {
		start = start+startIdx-1;
		end = end+startIdx-1;
		while(start<=end) {
			if(start%2==1) {
				count += tree[start];
			}
			if(end%2==0) {
				count += tree[end];
			}
			start=(start+1)/2;
			end=(end-1)/2;
		}
		
	}
	static void update(int index, int num) {
		index = startIdx + index -1;
		tree[index] = num;
		index/=2;
		while(index>0) {
			tree[index] = tree[index*2]+tree[index*2+1];
			index/=2;
		}
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<Integer, Integer>  graph = new HashMap<>();
	public static void main(String[] args) throws  IOException {
		N = Integer.parseInt(br.readLine());
		
		K = (int) Math.ceil(Math.log(N)/Math.log(2));
		startIdx =(int) Math.pow(2, K);
		Ntree =(int) Math.pow(2, K+1);
		tree = new int[Ntree];
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
		}
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < N+1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			graph.put(temp, i);
		}
		
		for (int i = 1; i < N+1; i++) {
			query(graph.get(arr[i])+1, N);
			update(graph.get(arr[i]),1);
		}
		System.out.println(count);
	}
}
