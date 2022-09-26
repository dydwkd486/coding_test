package baekjoon20057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,a[][];
	static int point_x,point_y;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		n = Integer.parseInt(br.readLine());
		a=new int[n+4][n+4];
		point_x = (n+4)/2;
		point_y = (n+4)/2;
		int total=0;
		for (int i = 2; i < n+2; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 2; j < n+2; j++) {
				a[i][j] = Integer.parseInt(token.nextToken());
				total+=a[i][j];
			}
		}
		
//		for (int[] i : a) {
//			System.out.println(Arrays.toString(i));
//		}
		int count=1;
		int rotate=0;
		while(true) {
			for (int i = 0; i < count; i++) {
				point_y = point_y+dy[rotate%4];
				point_x = point_x+dx[rotate%4];
//				System.out.println(a[point_y][point_x]+":"+point_y+":"+point_x);
//				System.out.println(a[point_y][point_x]);
				move(point_y,point_x,rotate%4);
				if(point_y==2 && point_x==2) {
					break;
				}
				
			}
			if(point_y==2 && point_x==2) {
				break;
			}
			rotate+=1;
			for (int i = 0; i < count; i++) {
				point_y = point_y+dy[rotate%4];
				point_x = point_x+dx[rotate%4];
				move(point_y,point_x,rotate%4);
//				System.out.println(a[point_y][point_x]+":"+point_y+":"+point_x);
//				System.out.println(a[point_y][point_x]);
				
			}
//			System.out.println();
			rotate+=1;
			count+=1;
		}
//		System.out.println();
//		for (int[] i : a) {
//			System.out.println(Arrays.toString(i));
//		}
		int result = 0;
		for (int i = 2; i < n+2; i++) {
			for (int j = 2; j < n+2; j++) {
				result+=a[i][j];
			}
		}
		System.out.println(total-result);
		
	}
	static void move(int point_y,int point_x,int rotate) {
		int temp = a[point_y][point_x];
		a[point_y][point_x]=0;
		int total=0;
		a[point_y-dy[rotate]+dy[(rotate+1)%4]][point_x-dx[rotate]+dx[(rotate+1)%4]] += (temp*1/100);
		a[point_y-dy[rotate]+dy[(rotate+3)%4]][point_x-dx[rotate]+dx[(rotate+3)%4]] +=(temp*1/100);
		a[point_y+dy[(rotate+1)%4]][point_x+dx[(rotate+1)%4]] += (temp*7/100);
		a[point_y+dy[(rotate+3)%4]][point_x+dx[(rotate+3)%4]] += (temp*7/100);
		a[point_y+(dy[(rotate+1)%4]*2)][point_x+(dx[(rotate+1)%4]*2)] += (temp*2/100);
		a[point_y+(dy[(rotate+3)%4]*2)][point_x+(dx[(rotate+3)%4]*2)] += (temp*2/100);
		a[point_y+dy[rotate]+dy[(rotate+1)%4]][point_x+dx[rotate]+dx[(rotate+1)%4]] += (temp*10/100);
		a[point_y+dy[rotate]+dy[(rotate+3)%4]][point_x+dx[rotate]+dx[(rotate+3)%4]] += (temp*10/100);
		a[point_y+dy[rotate]*2][point_x+dx[rotate]*2] += (temp*5/100);
		total+=(temp*1/100)*2+(temp*7/100)*2+(temp*2/100)*2+(temp*10/100)*2+(temp*5/100);
		a[point_y+dy[rotate]][point_x+dx[rotate]] += temp-total;
		
		
	}

}
