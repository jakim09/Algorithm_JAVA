class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1
        new_id = new_id.toLowerCase();
        
        //2
        for(int i = 0; i < new_id.length(); i++){
            char ch = new_id.charAt(i);
            if (Character.isAlphabetic(ch) || 
                Character.isDigit(ch) || 
                ch == '-' || ch == '_' || ch == '.')
                answer += ch;
        }
        
        //3
        while(answer.indexOf("..") != -1){
            answer = answer.replace("..", ".");
        }
        
        //4
        if(!answer.isEmpty() && answer.charAt(0) == '.'){
            answer = answer.substring(1);
        }
        if(!answer.isEmpty() && answer.charAt(answer.length()-1) == '.'){
            answer = answer.substring(0,answer.length()-1);
        }
        
        //5
        if(answer.isEmpty()){
            answer = "a";
        }
        
        //6
        if(answer.length() >= 16){
            answer = answer.substring(0,15);
            if(answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0,answer.length()-1);
        }
        }
        
        //7
        if(answer.length() <= 3){
            char c = answer.charAt(answer.length()-1);
            while(answer.length() < 3){
                answer += c;
            }
        }
        
        return answer;
    }
}