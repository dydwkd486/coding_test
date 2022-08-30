import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        answer[0] = arr[0];
        int count =0;
        for(int i = 1; i<arr.length;i++){
            if(answer[count]==arr[i]) continue;
            answer[++count] =arr[i];
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        answer = Arrays.copyOfRange(answer,0,count+1);
        return answer;
    }
}