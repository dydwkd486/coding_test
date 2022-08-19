package baekjoon12100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[][] graph;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] token = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(token[j]);
			}
		}
		// 입력 완료
		dfs(0,graph);
		System.out.println(result);
	}
	static void dfs(int cnt, int[][] graph) {
		if(cnt==5) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result = Math.max(result, graph[i][j]);
				}
			}
			return;
		}
		dfs(cnt+1,left(graph));
		dfs(cnt+1,right(graph));
		dfs(cnt+1,top(graph));
		dfs(cnt+1,down(graph));
		
//		print(temp);
	}
	
	static int[][] left(int[][] graph) {
		int[][] temp = new int[n][n];
		temp= deepCopy(temp,graph);
		int[][] newGraph = new int[n][n];
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
					newGraph[i][curPoint++]= tempCount*2;
					temp[i][j] = 0;
					tempCount = 0;
				}
				else if(temp[i][j]!=tempCount){
					newGraph[i][curPoint++]= tempCount;
					tempCount = temp[i][j];
				}
			}
			if(tempCount!=0) {
				newGraph[i][curPoint]= tempCount;
			}
			
		}
		return newGraph;
		
	}
	
	static int[][] right(int[][] graph) {
		int[][] temp = new int[n][n];
		temp= deepCopy(temp,graph);
		
		int[][] newGraph = new int[n][n];
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
					newGraph[i][curPoint--]= tempCount*2;
					temp[i][j] = 0;
					tempCount = 0;
				}
				else if(temp[i][j]!=tempCount){
					newGraph[i][curPoint--]= tempCount;
					tempCount = temp[i][j];
				}
			}
			if(tempCount!=0) {
				newGraph[i][curPoint]= tempCount;
			}
			
		}
		return newGraph;
		
	}
	
	static int[][] down(int[][] graph) {
		int[][] temp = new int[n][n];
		temp= deepCopy(temp,graph);
		
		int[][] newGraph = new int[n][n];
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
					newGraph[curPoint--][j]= tempCount*2;
					temp[i][j] = 0;
					tempCount = 0;
				}
				else if(temp[i][j]!=tempCount){
					newGraph[curPoint--][j]= tempCount;
					tempCount = temp[i][j];
				}
			}
			if(tempCount!=0) {
				newGraph[curPoint][j]= tempCount;
			}
			
		}
		return newGraph;
		
	}
	
	static int[][] top(int[][] graph) {
		int[][] temp = new int[n][n];
		temp= deepCopy(temp,graph);
		
		int[][] newGraph = new int[n][n];
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
					newGraph[curPoint++][j]= tempCount*2;
					temp[i][j] = 0;
					tempCount = 0;
				}
				else if(temp[i][j]!=tempCount){
					newGraph[curPoint++][j]= tempCount;
					tempCount = temp[i][j];
				}
			}
			if(tempCount!=0) {
				newGraph[curPoint][j]= tempCount;
			}
			
		}
		return newGraph;
		
	}
	
	
	static int[][] deepCopy(int[][] temp, int[][] graph){
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = graph[i][j];
			}
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
