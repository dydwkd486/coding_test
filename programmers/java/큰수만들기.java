import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        String[] number_list = number.split("");
        StringBuffer br = new StringBuffer();
        int result_count=number_list.length-k;
        stack.add(Integer.parseInt(number_list[0]));
        for(int num =1; num<number_list.length;num++){
            while(stack.size()>0 && stack.get(stack.size()-1)<Integer.parseInt(number_list[num]) && k>0){
                k-=1;
                stack.pop();
            }
            stack.add(Integer.parseInt(number_list[num]));
        }
        for(int i=0;i<result_count;i++){
            br.append(stack.get(i));
        }
        String answer = br.toString();
        return answer;
    }
}