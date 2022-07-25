import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//검은색과 흰색이 동시에 이기거나 검은색 또는 흰색이 두 군데 이상에서 동시에 이기는 경우는 없다고 가정
public class Main {
	static int result =1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx= {1,1,1,0};
		int[] dy={-1,0,1,1};
		int[][] graph=new int[21][21];
		int answer=0;
		int answer_grph_x=0;
		int answer_grph_y=0;
		//그래프에 삽입
		for(int i=1;i<20;i++) { 
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				graph[i][j]= Integer.parseInt(token.nextToken());
			}
		}
		//삽입 확인 출력
//		for(int[] i: graph) {
//			for(int j:i) {
//				System.out.print(j+" ");
//			}
//			System.out.println();
//		}
		
		stop:
		for(int i=1;i<20;i++) { //y
			for (int j = 1; j < 20; j++) { //x
				if(graph[i][j]!=0) {
					for(int k=0;k<4;k++) {
						result=1;
						if(graph[i-dy[k]][j-dx[k]]!=graph[i][j]) {
							dfs(j,i,graph,1,dx[k],dy[k],graph[i][j]);
//							System.out.println(result);
							if(result==5) {
//								System.out.println("정답!");
								answer=graph[i][j];
								answer_grph_x=j;
								answer_grph_y=i;
								break stop;
							}
						}
					}
				}
			}
		}
		if(answer==0) { //결과가 안나온 경우
			System.out.println(answer);
		}
		else { //결과가 나온 경우
			System.out.println(answer);
			System.out.println(answer_grph_y+" "+answer_grph_x);
		}
	}
	
	static void dfs(int j,int i,int[][] graph,int count,int dx,int dy,int color) {
		
		if(0<j+dx && j+dx<20 && 0<i+dy && i+dy<20) {
			if(graph[i+dy][j+dx]==color) {
				dfs(j+dx,i+dy,graph,count+1,dx,dy,color);
				result+=1;
			}	
		}
	}
}
