package baekjoon11437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] parents;
	static int[] depths;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int inputCnt = Integer.parseInt(br.readLine());
		tree = new ArrayList[inputCnt+1];
		for (int i = 1; i < inputCnt+1; i++) {
			tree[i] = new ArrayList<>();
		}
		parents = new int[inputCnt+1];
		depths = new int[inputCnt+1];
		Arrays.fill(depths, -1);
		for (int i = 0; i < inputCnt-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		dfs(1,1,0);
		int caseCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < caseCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = LCA(a,b);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		

	}
	static int LCA(int a,int b) {
		int aDepth = depths[a];
		int bDepth = depths[b];
		while(aDepth>bDepth) {
			a = parents[a];
			aDepth--;
		}
		while(bDepth>aDepth) {
			b= parents[b];
			bDepth--;
		}
		while(a!=b) {
			a = parents[a];
			b = parents[b];
		}
		return a;
	}
	static void dfs(int current,int depth, int parent) {
		depths[current] = depth;
		parents[current] = parent;
		for (int nextNode : tree[current]) {
			if(nextNode!= parent) {
				dfs(nextNode,depth+1,current);
			}
			
		}
	}

}
