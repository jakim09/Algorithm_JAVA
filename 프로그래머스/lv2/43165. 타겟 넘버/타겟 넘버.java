class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int curr, int target, int cnt){
        if(cnt == numbers.length){
            if(curr == target){
                answer++;
            }
            return;
        }
        dfs(numbers, curr + numbers[cnt], target, cnt+1);
        dfs(numbers, curr - numbers[cnt], target, cnt+1);
    }
}