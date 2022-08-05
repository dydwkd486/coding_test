import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			String[] token;
			int n = Integer.parseInt(br.readLine());
			String[] stack = new String[n];
			int pivot = 0;
			int result = 1;
			token = br.readLine().split("");
			for (int i = 0; i < stack.length; i++) {
				if(pivot!=0 && (token[i].equals(")") || token[i].equals(">") || token[i].equals("}") || token[i].equals("]")) ) {					
					if(token[i].equals(")") && stack[pivot-1].equals("(")) {
						pivot--;
					}
					else if(token[i].equals(">") && stack[pivot-1].equals("<")) {
						pivot--;
					}
					else if(token[i].equals("}") && stack[pivot-1].equals("{")) {
						pivot--;
					}
					else if(token[i].equals("]") && stack[pivot-1].equals("[")) {
						pivot--;
					}
					else {
						result=0;
						break;
					}
				}
				else {
					stack[pivot]=token[i];
					pivot++;
				}
				if(pivot<0) {
					result=0;
				}
			} //for end
			
			if(pivot!=0) {
				result=0;
			}
			sb.append("#"+tc+" "+result+"\n");			
		}
		System.out.println(sb);
	}
}
