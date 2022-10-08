package tree_kill_all;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3시 30분 시작~5시
// 인접한 네 개의 칸 중 나무가 있는 칸의 수만큼 나무가 성장
// 4개의 칸 중 벽,다른나무,제초제 모두 없는 같에 번식
// 옆에 칸으로 번식!
// 제초제 뿌려서 관리하는 리스트 필요할듯.
// 나무 관리
// 이미 제초제 뿌린곳은 다시 안뿌림.
// 제초제가 뿌려진 곳에 다시 제초제가 뿌려지는 경우에는 새로 뿌려진 해로부터 다시 c년동안 제초제가 유지(덮어쓰기)
public class Main {
	static int n, m, K, C, result;
	static int tree[][], kill[][];
	static int dx[] = new int[] { 0, 0, 1, -1 };
	static int dy[] = new int[] { 1, -1, 0, 0 };
	static int tx[] = new int[] { 1, -1, 1, -1 };
	static int ty[] = new int[] { 1, -1, -1, 1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		// 시작
		tree = new int[n][n];
		kill = new int[n][n];
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				tree[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		for (int tc = 0; tc < m; tc++) { // 총 m년 돌림

			// 나무의 성장
			// 현재 위치의 나무 확인하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (tree[i][j] > 0) { // 나무가 존재
						// 그 주변의 나무 개수 파악하기
						int count = 0;
						for (int k = 0; k < 4; k++) {
							int vy = i + dy[k];
							int vx = j + dx[k];
							if (-1 < vy && vy < n && -1 < vx && vx < n && tree[vy][vx] > 0) {
								count++;
							}
						}
						tree[i][j] += count;
					}
				}
			}
//			System.out.println("나무 자랐나 확인");
//			print(tree);
			// 나무의 번식
			// 현재위치에 나무가 있는지 확인
			// 클론 심는곳을 만들기
			int[][] cloneTree = new int[n][n];
			for (int i = 0; i < cloneTree.length; i++) {
				cloneTree[i] = tree[i].clone();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (tree[i][j] > 0) { // 나무가 존재
						// 그 주변에 제초제가 없어야하고, 나무가 없어야하고, 벽이 없어야함.
						int count = 0;
						// 심을수 있는 곳 확인
						for (int k = 0; k < 4; k++) {
							int vy = i + dy[k];
							int vx = j + dx[k];
							if (-1 < vy && vy < n && -1 < vx && vx < n && tree[vy][vx] == 0 && kill[vy][vx] == 0) {
								count++;
							}
						}
						int createTree = count == 0 ? 0 : tree[i][j] / count;
						// 그것의 카운트 만큼 나누어서 심어야함.
						for (int k = 0; k < 4; k++) {
							int vy = i + dy[k];
							int vx = j + dx[k];
							if (-1 < vy && vy < n && -1 < vx && vx < n && tree[vy][vx] == 0 && kill[vy][vx] == 0) {
								cloneTree[vy][vx] += createTree;
							}
						}
					}
				}
			}
			tree = cloneTree;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (kill[i][j] > 0) { // 나무가 존재
						kill[i][j]--;
					}
				}
			}
//			System.out.println("나무 번식했나 확인");
//			print(tree);
			// 제초제를 뿌릴 위치 선정
			// 대각선 K 범위 많큼 확인해야함. 대신 벽이 있으면 거기서 정지
			// 최대로 파괴되는 곳 파악하기
			int killY = -1;
			int killX = -1;
			int killCount = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 나무가 없는 곳에 뿌리면 효과없음.
					if (tree[i][j] > 0) { // 나무가 존재
						int count = tree[i][j]; // 부셔지는 나무 개수 확인하기
						for (int k = 0; k < 4; k++) {
							int vy = i;
							int vx = j;
							for (int c = 0; c < K; c++) {
								vy += ty[k];
								vx += tx[k];
								if (-1 < vy && vy < n && -1 < vx && vx < n) { // 테두리 안에 있음.
									if(tree[vy][vx]==0) {
										count += tree[vy][vx];
										break;
									}
									if (tree[vy][vx] == -1)
										break; // 벽이면 종료
									count += tree[vy][vx];
								}
							}

						} // 대각선 확인 end
						if (killCount < count) {
							killCount = count;
							killY = i;
							killX = j;
						}
					}
				} // 나무 한그루 end
			}
//			System.out.println("파괴할 위치와 개수는?");
//			System.out.println("killCount:" + killCount + " killY:" + killY + " killX:" + killX);

			result += killCount;
			// 마지막으로 제초제 1년 지나면 효능 떨어지는것을 어디서 해야하는지 파악하기
			// 현재 있는 제초제 1씩 줄이기


			// 제초제를 뿌리는 작업 진행
			// 이제 뿌려주면서 제거
			if (killY != -1) {

				kill[killY][killX] = C; // 첫 위치 제초제 뿌리기
				tree[killY][killX] = 0; // 첫 위치 나무 제거하기
				for (int k = 0; k < 4; k++) {
					int vy = killY;
					int vx = killX;
					for (int c = 0; c < K; c++) {
						vy += ty[k];
						vx += tx[k];
						if (-1 < vy && vy < n && -1 < vx && vx < n) {
							
							if(tree[vy][vx]==0) {
								kill[vy][vx] = C; // 제초제 뿌리기
								break;
							}
							if (tree[vy][vx] == -1)
								break; // 벽이면 종료
							kill[vy][vx] = C; // 제초제 뿌리기
							tree[vy][vx] = 0; // 나무 제거하기
						}
					}

				}
//			System.out.println("나무 제거 되었나 확인하기");
//			print(tree);
//			print(kill);
			}
		}
		System.out.println(result);
	}// end

	static void print(int[][] g) {
		for (int[] i : g) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}

}
