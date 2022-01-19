package 泛型;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example01 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("123");
        l.add("abc");
        l.add("abcd");
        l.add("abce");
        Iterator<String> it = l.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("==============");
        for (String s : l) {
            System.out.println(s);
        }
        
    }
}
