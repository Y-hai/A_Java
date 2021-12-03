package Test;

public class Example01 {
    public static void main(String[] args) {
        // char数据类型的默认值是\u0000
        // System.out.println('\u0000');
        // 变量arr储存在主栈中，new出来的数组对象储存在堆中
        String[] arr = new String[5];
        arr[0] = "123"; // "123"也对象储存在堆中，arr对象的第一个下标指向其地址
        for (int i = 0; i <= 4; i++) {
            System.out.println(arr[i]);
        }
//        System.exit(0);
    }
}
