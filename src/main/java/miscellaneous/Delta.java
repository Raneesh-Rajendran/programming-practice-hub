package main.java.miscellaneous;

import java.util.Collections;
import java.util.LinkedHashSet;

/*
   "java spring boot java raneesh"
    First non repetitve char

*/
public class Delta {

  public static void main(String[] args) {

    String sentence = "java spring boot java raneesh";

    //        Set<Character> orderedSet = new LinkedHashSet<>();

    //        for(Character aChar: sentence.toCharArray()) {
    //            if(!orderedSet.add(aChar)){
    //                orderedSet.remove(aChar);
    //            }
    //        }

    //        System.out.println("Result : " + orderedSet);

    char[] result =
        new LinkedHashSet<>(Collections.singletonList(sentence.toCharArray()))
            .stream().findFirst().get();
    System.out.println("Result : " + result[0]);
  }
}
