package baekjoon1062;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int n,r;
	static String[] name;
	static boolean[] input = new boolean[26];
	static int result;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] token = br.readLine().split(" ");
		n = Integer.parseInt(token[0]);
		r = Integer.parseInt(token[1]);
		name = new String[n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			str = str.replace("anta", "");
            str = str.replace("tica", "");	
			name[i]= str;
		}
		
		if(r<5) {
			System.out.println(0);
			return;
		}else if(r==26) {
			System.out.println(n);
			return;
		}
		else {
			input['a'-'a']=true;
			input['n'-'a']=true;
			input['t'-'a']=true;
			input['i'-'a']=true;
			input['c'-'a']=true;
			
			com(0,0);
			System.out.println(result);
			
		}
	}
	static void com(int idx, int cnt) {
		if(r-5 == cnt) {
			int count=0;
			for (int i = 0; i < n; i++) {
				boolean isValid=true;
				for (int j = 0; j < name[i].length(); j++) {
					if(!input[name[i].charAt(j)-97]) {
						isValid = false;
						break;
					}
						
				}
				if(isValid) {
					count++;
				}
			}
			result = Math.max(result, count);
			return;
			
		}
		for (int i = idx; i < 26; i++) {
			if(!input[i]) {
				input[i] = true;
				com(i,cnt+1);
				input[i] = false;
			}
			
		}
	}

}
