package 注解;

public class Example01 {
    public static void main(String[] args) {

    }
    public void doSome(){

    }
    @Deprecated
    // 这个注解代表元素已过时，这个方法应该被更新
    public void doOther(){
        System.out.println("Deprecated");
    }
}

class T {
    public static void main(String[] args) {
        new Example01().doOther();
    }
}
