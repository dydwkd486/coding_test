package baekjoon1072;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int x,y,z;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		x = Integer.parseInt(token.nextToken());
		y = Integer.parseInt(token.nextToken());
		z = (int) ((long) y * 100 / x);
        int ans = -1;
        int left = 0;
        int right = (int) 1e9;
        while(left <=right) {
        	int mid = (left+right)/2;
        	if((int) ((long) (y+mid) * 100 / (x+mid))!=z) {
        		ans = mid;
        		right = mid -1;
        	}
        	else {
        		left = mid +1;
        	}
        }
        System.out.println(ans);
	}

}
