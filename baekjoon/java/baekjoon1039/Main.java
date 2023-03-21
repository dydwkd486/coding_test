package baekjoon1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static boolean[][] visited = new boolean[11][1000001];
    static int answer = -1;
    
    public static class Pair {
    	int num, cnt;

		public Pair(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
    	
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Pair> q = new LinkedList<>();
		visited[0][N] = true;
		q.add(new Pair(N, 0));
		while(!q.isEmpty()) {
			Pair now = q.poll();
			if(now.cnt == K) {
				answer = Math.max(answer, now.num);
				continue;
			}
			int len = String.valueOf(N).length();
			for (int i = 0; i < len-1; i++) {
				for(int j=i+1;j<len;j++) {
					char[] swqpped = swap(now.num,i,j);
					int num = Integer.parseInt(String.valueOf(swqpped));
					if(swqpped[0]=='0' || visited[now.cnt+1][num]) continue;
					visited[now.cnt+1][num] = true;
					q.add(new Pair(num, now.cnt+1));
				}
				
			}
			
		}
		System.out.println(answer);
	}
    private static char[] swap(int num, int i, int j) {
    	StringBuilder sb = new StringBuilder(String.valueOf(num));
    	char temp = sb.charAt(i);
    	sb.setCharAt(i, sb.charAt(j));
    	sb.setCharAt(j, temp);
    	return sb.toString().toCharArray();
		
	}
}
