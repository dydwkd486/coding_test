package baekjoon3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] depths, parents;
	static int T,N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new ArrayList[N+1];
			for (int i = 1; i < N+1; i++) {
				tree[i] = new ArrayList<>();
				
			}
			parents = new int[N+1];
			depths = new int[N+1];
			boolean[] rootCheck = new boolean[N+1];
			Arrays.fill(rootCheck, true);
			Arrays.fill(depths, -1);
			for (int i = 0; i < N-1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tree[a].add(b);
//				tree[b].add(a);
				rootCheck[b]=false;
			}
			int rootIdx=0;
			for (int i = 1; i < N+1; i++) {
				if(rootCheck[i]) {
					rootIdx =i;
					break;
				}
			}
//			System.out.println("루트"+rootIdx);
			dfs(rootIdx,1,0);
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(LCA(a,b)).append("\n");
			
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
	static void dfs(int cur, int dep, int par) {
		depths[cur] = dep;
		parents[cur] = par;
		for (int nextNode : tree[cur]) {
			if(nextNode != par) {
				dfs(nextNode,dep+1,cur);
			}
		}
	}

}
