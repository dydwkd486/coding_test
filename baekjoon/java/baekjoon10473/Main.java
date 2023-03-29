package baekjoon10473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// baekjoon10473
	static final int INF = 987654321;
	static class Position {
		float x;
		float y;
		
		public Position(float x, float y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static class Node{
		int e;
		float cost;
		public Node(int e, float cost) {
			this.e = e;
			this.cost = cost;
		}
	}
	static ArrayList<Position> position = new ArrayList<>();
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		Position startP = new Position(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		Position endP = new Position(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken()));
		
		N = Integer.parseInt(br.readLine());
		position.add(startP);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			position.add(new Position(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken())));
		}
		position.add(endP);
		
		// 초기화
		for (int i = 0; i < N+2; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 처음은 달리기
		for (int i = 1; i < N+2; i++) {
			float dist= (float) Math.sqrt(Math.pow(position.get(0).x-position.get(i).x, 2)+Math.pow(position.get(0).y-position.get(i).y, 2));
			graph.get(0).add(new Node(i, dist));
		}
		for (int i = 1; i < N+2; i++) {
			for (int j = 1; j < N+2; j++) {
				if(i==j) continue;
				float dist= (float) Math.sqrt(Math.pow(position.get(i).x-position.get(j).x, 2)+Math.pow(position.get(i).y-position.get(j).y, 2));
				dist = Math.min(dist,Math.abs(dist-50.0f)+10);
//				System.out.println(dist);
				graph.get(i).add(new Node(j,dist));
			}
		}
		
		dijkstra();
	}
	static void dijkstra() {
		int start = 0;
		float[] dist = new float[N+2];
		Arrays.fill(dist, Float.MAX_VALUE);
		dist[start] =0;
		
		PriorityQueue<Node> q = new PriorityQueue<>((o1,o2) ->(Float.compare(o1.cost, o2.cost)));
		q.offer(new Node(start, 0.0f));
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			if(dist[curNode.e]<curNode.cost) continue;
			for (int i = 0; i < graph.get(curNode.e).size(); i++) {
				Node nxtNode = graph.get(curNode.e).get(i);
				if(dist[nxtNode.e] > nxtNode.cost+curNode.cost) {
					dist[nxtNode.e] = nxtNode.cost+curNode.cost;
					q.offer(new Node(nxtNode.e, dist[nxtNode.e]));
				}
				
			}
		}
//		System.out.println(Arrays.toString(dist));
		System.out.println(dist[N+1]/5);
		
	}

}
