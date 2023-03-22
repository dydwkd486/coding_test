package baekjoon1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	//backjoon1717
	static int[] parents;
	static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x] = find(parents[x]);
		
	}
	static void union(int x,int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
            if (x < y) {
            	parents[y] = x;
            } else {
            	parents[x] = y;
            }
        }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int a, b,c,n,m;
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parents[i]=i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(c==0) {
				union(a, b);
			}
			else if(c==1){
				sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");
			}
			else {
				continue;
			}
		}
		bw.write(sb.toString());
		bw.flush();
        bw.close();
        br.close();
	}
	   public static boolean isSameParent(int x, int y) {
	        x = find(x);
	        y = find(y);
	 
	        if (x == y) {
	            return true;
	        }
	 
	        return false;
	    }

}