import java.util.*;
import java.io.*;

class Solution {
    Set<Set<String>> ans;
    
    public int solution(String[] user_id, String[] banned_id) {
        ans = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());
        return ans.size();
    }
    public void dfs(String[] user_id, String[] banned_id, Set<String> s) {
        if(s.size() == banned_id.length) {
            if(checkBanned(banned_id, s)) {
               ans.add(new HashSet<>(s)); 
            }
            
            return;
        }
        for(String user: user_id) {
            if(!s.contains(user)) {
                s.add(user);
                dfs(user_id, banned_id, s);
                s.remove(user);                
            }
            
        }
    }
    public boolean checkBanned(String[] banned_id, Set<String> set) {
        int i = 0;
        for(String s: set) {
            if(!isSame(banned_id[i++], s)) {                
                return false;
            }
        }
        return true;
    }
    public boolean isSame(String a, String b) {
        if(a.length() != b.length())
            return false;
        
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '*')
                continue;            
            if(a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }
}