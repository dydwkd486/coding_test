import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int l,s;
	static Map<Integer,Queue<Integer>> graph;
	static Queue<Integer> queue;
	static int[] visited;
	static int result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		for (int tc = 1; tc <= 10; tc++) {
			result =0;
			graph = new HashMap<Integer, Queue<Integer>>();
			queue = new LinkedList<>();
			visited = new int[101];
			token = new StringTokenizer(br.readLine());
			l = Integer.parseInt(token.nextToken());
			s = Integer.parseInt(token.nextToken());
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < l/2; i++) {
				int key = Integer.parseInt(token.nextToken());
				int value = Integer.parseInt(token.nextToken());
				if(graph.get(key) == null) {
					graph.put(key,new LinkedList<>());					
				}
				graph.get(key).add(value);
			}
			visited[s]=1;
			queue.add(s);
			while(!queue.isEmpty()) {
				int v = queue.poll();
				if(graph.get(v) == null) continue;
				for (int i :graph.get(v)) {
					if(visited[i]==0) {
						visited[i]=visited[v]+1;
						queue.add(i);						
					}
				}
			}
			int count=0;
			for (int i = 100; i > -1; i--) {
				count = Math.max(count, visited[i]);
			}
			for (int i = 100; i > -1; i--) {
				if(count == visited[i]) {
					result=i;
					break;
				}
			}
			System.out.println("#"+tc+" "+result);
		}
	}

}
