package M07.D20;

import java.util.*;
/*
* https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 */
public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        String[] s = {"12","123","1235","567","88","12"};
        System.out.println(pb.solution(s));
    }
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (String s : phone_book) {
           hash.put(s, 0);
        }
        
       for (String k : hash.keySet()) {
           System.out.println(k.length());
           for (int j = 1; j <= k.length() - 1; j++) {
               if (hash.containsKey(k.substring(0, j))) {
                   return false;
               }
           }
       }
        
        return true;
    }
}