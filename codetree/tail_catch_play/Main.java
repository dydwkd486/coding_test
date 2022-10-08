package tail_catch_play;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;
//7시 30분 ~ 9시 47분 2시간 20분 정도?
// 크게 만들어야하는것
// 라운드에 맞춰서 움직이게 하기 0
// - 우 위 좌 하
// 테두리에서 움직이게 하기
// - 1. 움직이게 하기
// 어떻게 움직이게 할거야?
// 
// - 2. 라운드 시작 공 맞는 사람 찾기
//     - 
// - 3. 사람이 맞으면 점수 획득, 획득 한 후 꼬리와 머리 자리 변경

public class Main {
	static int n,m,k,result,graph[][],visited[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	static int mx[] = {0,1,0,-1};
	static int my[] = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		k = Integer.parseInt(token.nextToken()); // 라운드 수
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		int startPx[] = {0,0,n-1,n-1};
		int startPy[] = {0,n-1,n-1,0};
		int startCount =0;
		int y = startPy[startCount%4];
		int x = startPx[startCount%4];
		for (int tc = 0; tc < k; tc++) {
			// 라운드 시작
			// 시작 후 이동해야함.
			graphMove();
			int vy = y;
			int vx = x;
			while(true) {
//				System.out.print(graph[vy][vx]+" ");
				if(0<graph[vy][vx] && graph[vy][vx]<4) {
					targetCheck(vy,vx);
					break;
				}
				// 여기서 한칸 씩 확인이 가능하다. 처음 맞는 사람을 찾을 수 있다.
				// 처음 맞게 된 사람이 있다면 거기서 바로 다음 라운드로 이동한다.
				// 있는 경우 바로 break;
				vy += dy[startCount%4];
				vx += dx[startCount%4];
				if(!(-1<vy && vy<n && -1<vx && vx<n)) break;
			}
//			System.out.println();
			y += my[startCount%4];
			x += mx[startCount%4];
			if(!(-1<y && y<n && -1<x && x<n)) {
				startCount++;
				y = startPy[startCount%4];
				x = startPx[startCount%4];
			}
//			print(graph);
			// 라운드 종료
		}
		System.out.println(result);
	} // end
	
	static void graphMove() {
		int[][] clone = new int[n][n];
		for (int i = 0; i < n; i++) {
			clone[i] = graph[i].clone();
		}
		// 이동시 클론 그래프 하나 만들면 편하게 구현가능할거임
		// 그리고 이미 들린 곳은 안들리게 visited 사용
		// 머리는 4있는 곳으로 1로 변경 원래 위치 2로 변경
		// 꼬리 부분에서 2있는 곳을 4로 변경, 원래위치는 4로 변경
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(graph[i][j]==1) { // 머리
					boolean teilcheck = false;
					for (int k = 0; k < 4; k++) {
						int vy = i+dy[k];
						int vx = j+dx[k];
						if(-1<vy && vy<n && -1<vx && vx<n) {
							if(graph[vy][vx]==3) {
								teilcheck=true;
							}
						}
					}
					for (int k = 0; k < 4; k++) {
						int vy = i+dy[k];
						int vx = j+dx[k];
						if(-1<vy && vy<n && -1<vx && vx<n) {
							if(teilcheck) {
								if(graph[vy][vx]==3) { // 잉? 꼬리네?
									clone[vy][vx]=1; 
									clone[i][j]=2;
								}
							}
							else {
								if(graph[vy][vx]==4) { // 여기가 앞부분
									// 클론에 앞부분 이동, 원래 위치 2로 변경
									clone[vy][vx]=1; 
									clone[i][j]=2;
								}
							}
						}
					}

				}
				if(graph[i][j]==3) { // 꼬리
					boolean headcheck = false;
					for (int k = 0; k < 4; k++) {
						int vy = i+dy[k];
						int vx = j+dx[k];
						if(-1<vy && vy<n && -1<vx && vx<n) {
							if(graph[vy][vx]==1) {
								headcheck=true;
							}
						}
					}
					for (int k = 0; k < 4; k++) {
						int vy = i+dy[k];
						int vx = j+dx[k];
						if(-1<vy && vy<n && -1<vx && vx<n) {
							if(headcheck) {
								if(graph[vy][vx]==2) { // 잉? 머리네?
									clone[vy][vx]=3; 
									clone[i][j]=1;
								}
							}
							else {
								if(graph[vy][vx]==2) { // 여기가 뒷부분
									// 클론에 뒷부분 이동, 원래 위치 4로 변경
									clone[vy][vx]=3; 
									clone[i][j]=4;
								}
							}
						}
					}
				}
				
			}
		}
		graph = clone;
	}
	static void targetCheck(int ty, int tx) {
		int[][] visited = new int[n][n];
		// 먼저 머리 와 꼬리 찾기
		int[] head = new int[2];
		int[] tail = new int[2];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.addFirst(new int[] {ty,tx});
		visited[ty][tx] = 1;
		int totallen=1;
		
		if(graph[ty][tx]==1) { // 머리
			head = new int[] {ty,tx};
		}
		if(graph[ty][tx]==3) { //꼬리
			tail = new int[] {ty,tx};
		}
		while(!q.isEmpty()) {
			int[] temp = q.pollLast();
			int y = temp[0];
			int x = temp[1];
			for (int i = 0; i < 4; i++) {
				int vy = y+dy[i];
				int vx = x+dx[i];
				if(-1<vy && vy<n && -1<vx && vx<n) {
					if(graph[vy][vx] == 4 || graph[vy][vx] == 0) continue;
					if(visited[vy][vx]==0) {
						visited[vy][vx]=visited[y][x]+1;
						if(graph[vy][vx]==1) { // 머리
							head = new int[] {vy,vx};
						}
						if(graph[vy][vx]==3) { //꼬리
							tail = new int[] {vy,vx};
						}
						q.addFirst(new int[] {vy,vx});
						totallen++;
					}
				}
			}
		}
//		System.out.println("토탈 길이:"+totallen);
		// 머리로 부터 꼬리까지 채킹
		q = new ArrayDeque<>();
		q.add(head);
		visited = new int[n][n];
		visited[head[0]][head[1]] = 1;
		visited[tail[0]][tail[1]] = totallen;
		while(!q.isEmpty()) {
			int[] temp = q.pollLast();
			int y = temp[0];
			int x = temp[1];
			for (int i = 0; i < 4; i++) {
				int vy = y+dy[i];
				int vx = x+dx[i];
				if(-1<vy && vy<n && -1<vx && vx<n) {
					if(graph[vy][vx] == 4 || graph[vy][vx] == 0) continue;
					if(visited[vy][vx]==0) {
						visited[vy][vx]=visited[y][x]+1;
						q.addFirst(new int[] {vy,vx});
					}
				}
			}
		}
		
//		print(graph);
//		System.out.println(visited[ty][tx]); 
		// 맞은 사람의 위치 확인 -> 머리 찾기 -> 찾은 후에 몇번째 위치 인지 확인 -> 결과 저장
		result += (int)Math.pow(visited[ty][tx], 2);
		// 결과 저장후 머리와 헤드 위치 변경
//		print(visited);
		graph[head[0]][head[1]] = 3;
		graph[tail[0]][tail[1]] = 1;
//		print(graph);
		
	}
	static void print(int[][] g) {
		for (int[] i : g) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}
}
