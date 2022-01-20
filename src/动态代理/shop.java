package 动态代理;

public class shop {
    public static void main(String[] args) {
//        taoBao t = new taoBao();
//        float price = t.sell(1);
        weiShang w = new weiShang();
        float price = w.sell(1);
        System.out.println(price);
    }
}
