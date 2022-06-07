import java.util.HashSet;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // report 중복제거
        HashSet<String> reportSet = new HashSet<String>();
        for(String re : report){
            reportSet.add(re);
        }
        
        HashMap<String, Integer> repo = new HashMap<String, Integer>();
        HashMap<String, Integer> mail = new HashMap<String, Integer>();
        
        for(int i = 0; i < id_list.length; i++){
            repo.put(id_list[i], 0);
            mail.put(id_list[i], i);
        }
        
        // 신고 받은 횟수
        for(String re : reportSet){
            StringTokenizer st = new StringTokenizer(re);
            String userId = st.nextToken();
            String repoId = st.nextToken();
            repo.put(repoId, repo.get(repoId)+1);
        }
        
        // 메일 전송 횟수
        for(String re : reportSet){
            StringTokenizer st = new StringTokenizer(re);
            String userId = st.nextToken();
            String repoId = st.nextToken();
            if(repo.get(repoId) >= k){
                answer[mail.get(userId)]++;
            }
        }
        

        
        return answer;
    }
}