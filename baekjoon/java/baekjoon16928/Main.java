package baekjoon16928;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] graph;
	static boolean[] selected = new boolean[101];
	static int[] result = new int[101];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int n,m;
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		graph = new int[101];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = i;
		}
		for (int i = 0; i < n+m; i++) {
			token = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(token.nextToken());
			int temp2 = Integer.parseInt(token.nextToken());
			graph[temp1] = temp2;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		selected[1]=true;
		while(!queue.isEmpty()) {
			int v = queue.poll();
			if(v == 100) {
				break;
			}
			for (int i = 1; i <= 6; i++) {
				if(100>= v+i) {
					if(!selected[graph[v+i]]) {
						selected[graph[v+i]] = true;
						queue.offer(graph[v+i]);
						result[graph[v+i]]=result[v]+1;
					}
				}
			}
		}
		System.out.println(result[100]);
		
	}
}
