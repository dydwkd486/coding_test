package baekjoon5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int e;
		int cost;
		
		public Node(int e, int cost) {
			this.e = e;
			this.cost = cost;
		}
		
	}
	static final int INF = 987654321;
	static ArrayList<ArrayList<Node>> graph;
	static ArrayList<ArrayList<Integer>> path;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,S,D,U,V,P;
	static boolean[][] check;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true) {
			graph = new ArrayList<ArrayList<Node>>();
			path = new ArrayList<ArrayList<Integer>>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			check = new boolean[N+1][N+1];
			if(N==0 && M==0) {
				break;
			}
			for (int i = 0; i < N+1; i++) {
				graph.add(new ArrayList<>());
				path.add(new ArrayList<>());
			}
			// 배열 크기 정의
			int dist[] = new int[N+1];
			Arrays.fill(dist,INF);

			// 시작과 끝 받기
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D= Integer.parseInt(st.nextToken());
			dist[S] = 0;

			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				U = Integer.parseInt(st.nextToken());
				V = Integer.parseInt(st.nextToken());
				P = Integer.parseInt(st.nextToken());
				graph.get(U).add(new Node(V, P));
			}
			
			// 다익스트라 시작
			PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->(Integer.compare(o1.cost, o2.cost)));
			
			q.offer(new Node(S,0));
			while(!q.isEmpty()) {
				Node curNode = q.poll();
				if(dist[curNode.e]<curNode.cost) {
					continue;
				}
				for (int i = 0; i < graph.get(curNode.e).size(); i++) {
					Node nxtNode = graph.get(curNode.e).get(i);
					if(dist[nxtNode.e]==nxtNode.cost+curNode.cost) {
						path.get(nxtNode.e).add(curNode.e);
						
					}
					if(dist[nxtNode.e]>nxtNode.cost+curNode.cost) {
						dist[nxtNode.e]=nxtNode.cost+curNode.cost;
						path.get(nxtNode.e).clear();
						path.get(nxtNode.e).add(curNode.e);
						q.offer(new Node(nxtNode.e, dist[nxtNode.e]));
					}	
				}
			}
//			System.out.println(dist[D]);
			
			removeEdge(D);
			Arrays.fill(dist,INF);
			q = new PriorityQueue<>((o1,o2)->(Integer.compare(o1.cost, o2.cost)));
			q.offer(new Node(S,0));
			while(!q.isEmpty()) {
				Node curNode = q.poll();
				if(dist[curNode.e]<curNode.cost) {
					continue;
				}

				for (int i = 0; i < graph.get(curNode.e).size(); i++) {
					Node nxtNode = graph.get(curNode.e).get(i);
					if (check[curNode.e][nxtNode.e]) continue;//제거된 간선
					
					if(dist[nxtNode.e]>nxtNode.cost+curNode.cost) {
						dist[nxtNode.e]=nxtNode.cost+curNode.cost;
						path.get(nxtNode.e).clear();
						path.get(nxtNode.e).add(curNode.e);
						q.offer(new Node(nxtNode.e, dist[nxtNode.e]));
					}	
				}
			}
//			System.out.println(Arrays.toString(dist));
			sb.append(dist[D]==INF ? -1 : dist[D]).append("\n");
			
		}
		System.out.println(sb);
	}
	public static void removeEdge(int v) {
		for (int bv : path.get(v)) {
			if (check[bv][v]) continue;
			check[bv][v] = true;
			removeEdge(bv);
		}
	}

}
