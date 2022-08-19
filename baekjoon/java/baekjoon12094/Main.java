package baekjoon12094;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] graph;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		StringTokenizer stz;
		for (int i = 0; i < n; i++) {
			stz = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(stz.nextToken());
			}
		}
		// 입력 완료
		dfs(0);
		System.out.println(result);
	}
	static void dfs(int cnt) {
		if(cnt==10) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result = Math.max(result, graph[i][j]);
				}
			}
			return;
		}
		int[][] temp = new int[n][n];
		temp= deepCopy(temp,graph);
		
		left(graph);
		dfs(cnt+1);
		graph= deepCopy(graph,temp);
		
		right(graph);
		dfs(cnt+1);
		graph= deepCopy(graph,temp);
		
		top(graph);
		dfs(cnt+1);
		graph= deepCopy(graph,temp);
		
		down(graph);
		dfs(cnt+1);
		graph= deepCopy(graph,temp);

//		print(left(temp));
//		print(right(temp));
	}
	
	static int[][] left(int[][] temp) {

		for (int i = 0; i < n; i++) {
			int curPoint=0;
			int j=0;
			int tempCount = temp[i][j];
			while(true) {
				j++;
				if(j>n-1) break;
				if(temp[i][j] ==0) continue;
				if(tempCount==0) {
					tempCount=temp[i][j];
					continue;
				}
				if(temp[i][j]==tempCount) {
					temp[i][curPoint++]= tempCount*2;
					temp[i][j] = 0;
					tempCount = 0;
				}
				else if(temp[i][j]!=tempCount){
					temp[i][curPoint++]= tempCount;
					tempCount = temp[i][j];
				}
			}
			if(tempCount!=0) {
				temp[i][curPoint++]= tempCount;
			}
			while(curPoint<n) {
				temp[i][curPoint++] = 0;
			}
			
		}
//		print(temp);
		return temp;
		
	}
	
	static int[][] right(int[][] temp) {
		
		for (int i = 0; i < n; i++) {
			int curPoint=n-1;
			int j=n-1;
			int tempCount = temp[i][j];
			while(true) {
				j--;
				if(j<0) break;
				if(temp[i][j] ==0) continue;
				if(tempCount==0) {
					tempCount=temp[i][j];
					continue;
				}
				if(temp[i][j]==tempCount) {
					temp[i][curPoint--]= tempCount*2;
					temp[i][j] = 0;
					tempCount = 0;
				}
				else if(temp[i][j]!=tempCount){
					temp[i][curPoint--]= tempCount;
					tempCount = temp[i][j];
				}
			}
			if(tempCount!=0) {
				temp[i][curPoint--]= tempCount;
			}
			while(curPoint>-1) {
				temp[i][curPoint--] = 0;
			}
			
		}
		return temp;
		
	}
	
	static int[][] down(int[][] temp) {
		
		for (int j = 0; j < n; j++) {
			int curPoint=n-1;
			int i=n-1;
			int tempCount = temp[i][j];
			while(true) {
				i--;
				if(i<0) break;
				if(temp[i][j] ==0) continue;
				if(tempCount==0) {
					tempCount=temp[i][j];
					continue;
				}
				if(temp[i][j]==tempCount) {
					temp[curPoint--][j]= tempCount*2;
					temp[i][j] = 0;
					tempCount = 0;
				}
				else if(temp[i][j]!=tempCount){
					temp[curPoint--][j]= tempCount;
					tempCount = temp[i][j];
				}
			}
			if(tempCount!=0) {
				temp[curPoint--][j]= tempCount;
			}
			while(curPoint>-1) {
				temp[curPoint--][j] = 0;
			}
			
		}
		return temp;
		
	}
	
	static int[][] top(int[][] temp) {
		
		for (int j = 0; j < n; j++) {
			int curPoint=0;
			int i=0;
			int tempCount = temp[i][j];
			while(true) {
				i++;
				if(i>n-1) break;
				if(temp[i][j] ==0) continue;
				if(tempCount==0) {
					tempCount=temp[i][j];
					continue;
				}
				if(temp[i][j]==tempCount) {
					temp[curPoint++][j]= tempCount*2;
					temp[i][j] = 0;
					tempCount = 0;
				}
				else if(temp[i][j]!=tempCount){
					temp[curPoint++][j]= tempCount;
					tempCount = temp[i][j];
				}
			}
			if(tempCount!=0) {
				temp[curPoint++][j]= tempCount;
			}
			while(curPoint<n) {
				temp[curPoint++][j] = 0;
			}
			
		}
		return temp;
		
	}
	
	
	static int[][] deepCopy(int[][] temp, int[][] graph){
		for (int i = 0; i < temp.length; i++) {
				temp[i] = graph[i].clone();
		}
		return temp;
	}
	static void print(int[][] graph) {
		for (int[] is : graph) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
}
