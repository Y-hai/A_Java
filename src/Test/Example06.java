package Test;

public class Example06 {
    public static void main(String[] args) {
        aaa a = new aaa();
        a.toString();
        System.out.println("123"+String.valueOf(123));
    }
}


class aaa {
    @Override
    public String toString() {
        System.out.println("就这？");
        return "hh";
    }
}
