import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean isScramble(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s1.length();i++){
            Character ch = s1.charAt(i);
            Integer cnt = map.get(ch);
            if(cnt!=null){
                map.put(ch,++cnt);
            }else{
                map.put(ch,1);
            }
        }
        
        for(int j=0;j<s2.length();j++){
            Character ch = s2.charAt(j);
            Integer cnt = map.get(ch);
            if(cnt!=null && cnt!=0){
                map.put(ch,--cnt);
            }
        }
        
         int sum = 0;
         for (Map.Entry<Character, Integer> entry : map.entrySet()) {
             Integer val = entry.getValue();
             sum+=val;
         }
         
         if(sum==0){
            return true; 
         }
         return false;
        
    }
    
    public static void main(String[] args) {
		String s1 ="ab";
		String s2="aa";
		System.out.println(isScramble(s1,s2));
	}
}