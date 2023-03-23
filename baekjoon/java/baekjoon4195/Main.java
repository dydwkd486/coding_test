package baekjoon4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] count;
	static int find(int x) {
		if(x==parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if(x!=y) {
			parent[y]=x;
			count[x]+=count[y];
			
			count[y]=1;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String a,b;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			Map<String, Integer> graph = new HashMap<>();
			int F = Integer.parseInt(br.readLine());
			parent = new int[F*2];
			count = new int[F*2];
			for (int j = 0; j < F*2; j++) {
				parent[j] = j;
				count[j] = 1;
			}
			int idx=0;
			for (int j = 0; j < F; j++) {
				st = new StringTokenizer(br.readLine());
				a = st.nextToken();
				b = st.nextToken();
				if(!graph.containsKey(a)) {
					graph.put(a, idx++);
				}
				if(!graph.containsKey(b)) {
					graph.put(b, idx++);
				}
				
				union(graph.get(a),graph.get(b));
				
				sb.append(count[find(graph.get(a))]+"\n");
				
			}
		}
		System.out.println(sb.toString());

	}

}
