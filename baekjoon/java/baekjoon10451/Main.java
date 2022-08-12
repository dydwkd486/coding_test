package baekjoon10451;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		StringBuilder sb= new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine());
			int[] n_list = new int[n+1];
			boolean[] isChecked = new boolean[n+1];
			int count=0;
			for (int i = 1; i < n+1; i++) {
				n_list[i]=Integer.parseInt(token.nextToken());
			}

			for (int i = 1; i < n+1; i++) {
				if(!isChecked[i]) {
					isChecked[i]=true;
					int temp = n_list[i];
					while(true) {
						if(!isChecked[temp]) {
							isChecked[temp] = true;
							temp = n_list[temp];
						}
						else {
							break;
						}
					}
					count++;
				}

			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}
