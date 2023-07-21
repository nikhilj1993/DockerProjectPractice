package Practice;

import java.util.*;

public class Interview {

    public static void main(String args[]){
       List<String> al = new ArrayList();
        al.add("3");
        al.add("3");
        al.add("4");
        al.add("2");
       al.add("1");
       al.add("2");
       al.add("3");

       LinkedHashSet<String> set = new LinkedHashSet<>();

       for(String a:al){
           set.add(a);
       }
        System.out.println(al);
        System.out.println(set);

    }
}
