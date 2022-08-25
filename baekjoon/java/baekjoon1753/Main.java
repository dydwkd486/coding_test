package baekjoon1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int v,e,s;
	static ArrayList<ArrayList<Node>> graph;
	static class Node{
		int idx,cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		v = Integer.parseInt(token.nextToken());
		e = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		s = Integer.parseInt(token.nextToken());
		graph = new ArrayList<>();
		for (int i = 0; i < v+1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			token = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			graph.get(s).add(new Node(e,c));
		}
		
		int[] dist = new int[v+1];
		for (int i = 0; i < v+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.cost, o2.cost));
		queue.offer(new Node(s,0));
		dist[s] = 0;
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			if(dist[curNode.idx]< curNode.cost) continue;
			for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
				Node nextNode = graph.get(curNode.idx).get(i);
				if(dist[nextNode.idx]> curNode.cost+nextNode.cost) {
					dist[nextNode.idx] = curNode.cost+nextNode.cost;
					queue.offer(new Node(nextNode.idx,dist[nextNode.idx]));
				}
			}
		}
//		System.out.println(Arrays.toString(dist));
		for (int i = 1; i < dist.length; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);				
			}
		}
	}

}
