package baekjoon1197;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int v,e, parents[];
	static Edge[] edgeList;
	static class Edge implements Comparable<Edge>{
		int f,t,w;
		
		public Edge(int f, int t, int w) {
			super();
			this.f = f;
			this.t = t;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		v= Integer.parseInt(token.nextToken());
		e= Integer.parseInt(token.nextToken());
		edgeList = new Edge[e];
		parents = new int[v+1];
		for (int i = 0; i < e; i++) {
			token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			edgeList[i] = new Edge(a, b, c);	
		}
		System.out.println(kruskal());
	}
	static int kruskal() {
		int res = 0, cnt = 0;
		Arrays.sort(edgeList);
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
		for (Edge edge : edgeList) {
			if(union(edge.f,edge.t)) {
				res += edge.w;
				if(++cnt == v-1) return res;
			}
		}
		return e;
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
	}
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

}
