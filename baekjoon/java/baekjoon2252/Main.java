package baekjoon2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

public class Main {
	static int[] n_list;
	static int n,m;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		n_list = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken())-1;
			int b = Integer.parseInt(token.nextToken())-1;
			graph.get(a).add(b);
			n_list[b]++;
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if(n_list[i]!=0) continue;
			q.addFirst(i);
		}
		while(!q.isEmpty()) {
			int nodeNo = q.pollLast();
			sb.append((nodeNo+1)+" ");
			ArrayList<Integer> list = graph.get(nodeNo);
			for (int i = 0; i < list.size(); i++) {
				n_list[list.get(i)]--;
				if(n_list[list.get(i)]!=0) continue;
				q.addFirst(list.get(i));
			}
		}
		System.out.println(sb);
	}

}
