import java.util.Arrays;

class Solution {
    private static int n,m;
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int t = 0; t < commands.length; t++){
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            
            // int[] temp = new int[j-i+1];
            // int cnt = 0;
            // for(int a = i; a < j+1; a++){
            //     temp[cnt++] = array[a-1];
            // }
            
            int[] temp = Arrays.copyOfRange(array, i-1, j);
            
            Arrays.sort(temp);
            
            answer[t] = temp[k-1];
            
        }
        
        return answer;
    }
}