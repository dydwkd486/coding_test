package day0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int t,n,result,n_list[],start[]= new int[3];
	static boolean select[] = new boolean[3];
	static int[][] gate = new int[3][2];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		t = Integer.parseInt(token.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			n_list= new int[n];
			result = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				token = new StringTokenizer(br.readLine());
				int temp1 = Integer.parseInt(token.nextToken())-1;
				int temp2 = Integer.parseInt(token.nextToken());
				gate[i][0] = temp1;
				gate[i][1] = temp2;
			}
			per(0);
			System.out.println("#"+tc+" "+result);
		} // tc end
	}
	static void per(int cnt) {
		if(cnt==3) {
			gateMove(0,n_list);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if(select[i]) continue;
			select[i] = true;
			start[cnt] = i;
			per(cnt+1);
			select[i]=false;
		}
	}
	static void gateMove(int cnt,int[] n_list) {
		int[] temp = new int[n];
		if(cnt==3) { // 종료
			int sum = 0;
//			System.out.println(Arrays.toString(n_list));
			for (int i = 0; i < n_list.length; i++) {
				sum+=n_list[i];
			}
//			System.out.println(sum);
			result = Math.min(result, sum);
			return;
		}
		if(gate[start[cnt]][1]%2==0) {
			temp = stageSelcted(n_list,gate[start[cnt]][0],gate[start[cnt]][1],true);
			gateMove(cnt+1,temp);
			temp = stageSelcted(n_list,gate[start[cnt]][0],gate[start[cnt]][1],false);
			gateMove(cnt+1,temp);
		}
		else {
			temp = stageSelcted(n_list,gate[start[cnt]][0],gate[start[cnt]][1],true);			
			gateMove(cnt+1,temp);
		}
	}
	static int[] stageSelcted(int[] n_list, int gateNum,int count, boolean reverse) {
		int[] temp_list = n_list.clone();
		int temp = 1;
		if(count==0) {
			return n_list;
		}
		if(temp_list[gateNum]==0) {
			temp_list[gateNum]=1;
			count-=1;
		}
		while(count>1) {
			if(gateNum+temp<n) { // 한칸 증가
				if(temp_list[gateNum+temp]==0) {	
					temp_list[gateNum+temp]=temp+1;	
					count-=1;
				}			
			}
			if(-1<gateNum-temp) { // 한칸 감소
				if(temp_list[gateNum-temp]==0) {
					temp_list[gateNum-temp]=temp+1;
					count-=1;
				}
			}
			temp++;
		}
		if(reverse) {
			while(count==1) {
				if(gateNum+temp<n) { // 한칸 증가
					if(temp_list[gateNum+temp]==0) {	
						temp_list[gateNum+temp]=temp+1;	
						count-=1;
						break;
					}			
				}
				if(-1<gateNum-temp) { // 한칸 감소
					if(temp_list[gateNum-temp]==0) {
						temp_list[gateNum-temp]=temp+1;
						count-=1;
						break;
					}
				}
				temp++;
			}
		}
		else {
			while(count==1) {
				if(-1<gateNum-temp) { // 한칸 감소
					if(temp_list[gateNum-temp]==0) {
						temp_list[gateNum-temp]=temp+1;
						count-=1;
						break;
					}
				}
				if(gateNum+temp<n) { // 한칸 증가
					if(temp_list[gateNum+temp]==0) {	
						temp_list[gateNum+temp]=temp+1;	
						count-=1;
						break;
					}			
				}
				temp++;
			}
		}
		
		
		return temp_list;
	}
}
