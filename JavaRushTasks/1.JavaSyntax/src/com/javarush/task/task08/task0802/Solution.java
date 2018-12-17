package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
       HashMap<String, String> s = new HashMap<>();
      s.put("арбуз", "ягода");
      s.put("банан", "трава");
      s.put("вишня", "ягода");
      s.put("груша", "фрукт");
      s.put("дыня", "овощ");
      s.put("ежевика", "куст");
      s.put("жень-шень", "корень");
      s.put("земляника", "ягода");
      s.put("ирис", "цветок");
      s.put("картофель", "клубень");

      for(Map.Entry<String,String> pair:s.entrySet()){

          String k=pair.getKey();
          String v = pair.getValue();

          System.out.println(k+" - "+v);

      }

    }
}
