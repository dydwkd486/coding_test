package artistry;
 // 4시 40분~ 6시 00분
// 12시 20분~
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, graph[][],graphNum[][],result,visited[][],n_list_visited[];
    static ArrayList<Integer> n_list = new ArrayList<>();
    static ArrayList<Integer> n_list_num = new ArrayList<>();
    static int dy[] = {0,0,1,-1}; //좌우 하상
    static int dx[] = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer token;
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        
        for (int t = 0; t < 4; t++) {
            graphNum = new int[n][n];
            visited = new int[n][n];
            n_list.clear();
            n_list_num.clear();
            n_list.add(0);
            n_list_num.add(0);
            int num=1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(graphNum[i][j]!=0)continue;
                    graphNumberCreate(i,j,num++);
                }
            }
//            print(graph);
//            print(graphNum);
//            System.out.println(n_list);
//            System.out.println(n_list_num);
//            System.out.println();
            n_list_visited = new int[n_list.size()];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]!=0) continue;
                    graphBoundaryCount(i,j);                
                }
            }
            
            
            // 여기서 그래프 회전 시키기
            int[] clone = graph[n/2].clone();
            
            for (int i = 0; i < clone.length; i++) {
				graph[n/2][i] = graph[i][n/2];
			}
            for (int i = 0; i < clone.length; i++) {
				graph[n-1-i][n/2] = clone[i];
			}
            
            
            // 가운데 움직이기
            // 0,0 0,1 1,0 1,1
            int[][] cloneGraph = new int[n][n];
            for (int i = 0; i < clone.length; i++) {
				cloneGraph[i] = graph[i].clone();
			}
            int sub = (n-1)/2;
            ArrayList<int[]> subList = new ArrayList<>() ;
            subList.add(new int[] {0,0});
            subList.add(new int[] {0,1*sub+1});
            subList.add(new int[] {1*sub+1,0});
            subList.add(new int[] {1*sub+1,1*sub+1});
            for (int v = 0; v < subList.size(); v++) {
				for (int i = 0; i < sub; i++) {
					for (int j = 0; j < sub; j++) {
						int y = subList.get(v)[0];
						int x = subList.get(v)[1];
						graph[y+i][x+j] = cloneGraph[y+sub-j-1][x+i];
					}
				}
			}
//            print(graph);
        }
        System.out.println(result);

        
        
        
    }
    static void graphBoundaryCount(int i,int j) {
        ArrayList<Integer> boundaryCount = new ArrayList<>();
        for (int k = 0; k < n_list.size(); k++) {
            boundaryCount.add(0);
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addFirst(new int[] {i,j});
        visited[i][j] = 1;
        while(!q.isEmpty()) {
            int[] temp = q.pollLast();
            int y = temp[0];
            int x = temp[1];
            for (int k = 0; k < 4; k++) {
                int vy = y+dy[k];
                int vx = x+dx[k];
                if(-1<vy && vy<n && -1<vx && vx<n) { // 안에 있어야함.
                    //같으면 추가 및 방문처리 다르면 체크만하기
                    if(graphNum[vy][vx]==graphNum[i][j]) {
                        if(visited[vy][vx]!=0) continue;
                        visited[vy][vx] = 1;
                        q.addFirst(new int[] {vy,vx});
                    }
                    else {
                        boundaryCount.set(graphNum[vy][vx], boundaryCount.get(graphNum[vy][vx])+1);                         
                    }
                }
            }
        }
//        System.out.println("?");
//        System.out.println(boundaryCount);
//        System.out.println(Arrays.toString(n_list_visited));
        
        for (int k = 0; k < n_list_visited.length; k++) {
            if(n_list_visited[k]!=0) continue;
            if(boundaryCount.get(k)==0) continue;
//            System.out.println((n_list.get(graphNum[i][j])+n_list.get(k)));
//            System.out.println(n_list_num.get(k));
//            System.out.println(n_list_num.get(graphNum[i][j]));
//            System.out.println(boundaryCount.get(k));
            result+=(n_list.get(graphNum[i][j])+n_list.get(k))*n_list_num.get(k)*n_list_num.get(graphNum[i][j])*boundaryCount.get(k);
//            System.out.println();
        }
        n_list_visited[graphNum[i][j]]=1;
//        print(visited);
    }
    static void graphNumberCreate(int i, int j,int num) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.addFirst(new int[] {i,j});
        graphNum[i][j]=num;
        int count=1;
        while(!q.isEmpty()) {
            int[] temp = q.pollLast();
            int y = temp[0];
            int x = temp[1];
            for (int k = 0; k < 4; k++) {
                int vy = y+dy[k];
                int vx = x+dx[k];
                if(-1<vy && vy<n && -1<vx && vx<n) {
                    if(graphNum[vy][vx]!=0) continue;
                    if(graph[vy][vx]==graph[i][j]) {
                        graphNum[vy][vx]=num;
                        count++;
                        q.addFirst(new int[] {vy,vx});
                    }
                }
            }
        }
        n_list_num.add(graph[i][j]);
        n_list.add(count);
        
    }
    static void print(int[][] g) {
        for (int[] is : g) {
            
            System.out.println(Arrays.toString(is));
        }
        System.out.println();
    }
}