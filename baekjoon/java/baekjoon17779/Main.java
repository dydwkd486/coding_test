package baekjoon17779;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,graph[][];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		
		// 입력 완료
		
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				for (int d1 = 1; d1 < n; d1++) {
					for (int d2 = 1; d2 < n; d2++) {
						if(1<=x+d1+d2 && x+d1+d2<=n && 1<=y-d1 && y-d1<y && y<y+d2 && y+d2<=n) {
							int[] n_min_max_list = new int[5];
							int[][] count_graph = new int[n][n];
							boundary(x, y, d1, d2, count_graph);
							for (int i = 0; i < n+1; i++) {
								for (int j = 0; j < n+1; j++) {
		                            if (1<=i && i<x+d1 && 1<=j && j<=y) {
		                            	if(count_graph[i-1][j-1]==0)
		                            		n_min_max_list[0] += graph[i-1][j-1];
		                            }    
		                            else if (1<=i && i<=x+d2 && y<j && j<=n){
		                            	if(count_graph[i-1][j-1]==0)
		                            		n_min_max_list[1] += graph[i-1][j-1];
		                            }    
		                            else if (x+d1<=i && i<=n && 1<=j && j<y-d1+d2) {
		                            	if(count_graph[i-1][j-1]==0)
		                            		n_min_max_list[2] += graph[i-1][j-1]; 
		                            }
		                            else if (x+d2<i && i<=n && y-d1+d2<=j && j<=n) {
		                            	if(count_graph[i-1][j-1]==0)
		                            		n_min_max_list[3] += graph[i-1][j-1];
		                            	
		                            }
		                            try {
										
		                            	if (count_graph[i-1][j-1]==5)
		                            		n_min_max_list[4] += graph[i-1][j-1];
									} catch (Exception e) {
										// TODO: handle exception
										continue;
									}
								}
								
							}
							Arrays.sort(n_min_max_list);
							result = Math.min(result , n_min_max_list[n_min_max_list.length-1]-n_min_max_list[0]);
						}
					}
				}
			}
		}
		System.out.println(result);
	}
	static void boundary(int x,int y,int d1,int d2,int[][] count_graph) {
		
		for (int i = 0; i < d1+1; i++) {
			for (int j = 0; j < d2+1; j++) {
				try {
		            count_graph[x+i-1][y-i-1] = 5;
	                count_graph[x+j-1][y+j-1] = 5;
	                count_graph[x+d1+j-1][y-d1+j-1] = 5;
	                count_graph[x+d2+i-1][y+d2-i-1] = 5;
				} catch (Exception e) {
					continue;
				}

			}
		}
		for (int i = x; i < x+d1+d2-1; i++) {
			boolean temp = false;
			for (int j = 0; j < count_graph.length; j++) {
				if(count_graph[i][j]==5) {
					if(temp == false) {
						temp = true;
					}
					else {
						temp = false;
					}
					
				}
				if (temp == true) {
					count_graph[i][j] = 5;
				}
			}
		}
	}
}
