package 动态代理;

public class taoBao implements usbSell {
    private usbKing f = new usbKing();

    @Override
    public float sell(int amount) {
        /**
         * 静态代理
         * 优点：
         * 1.实现目标方法的调用
         * 2.实现功能增强
         * 缺点：
         * 1.目标增加了，代理会成倍的增加
         * 2.接口中增加功能，会影响更多的实现类
         *
         * 动态代理：在程序执行过程中，使用反射创建代理类对象，并动态的指定代理目标类，
         * 可以不用创建代理类就能创建代理对象，目标类是活动的，可设置的
         * 优点：
         * 1.即使目标类很多，代理类也可以很少
         * 2.修改接口中的方法不会影响代理类
         */
        float price = f.sell(amount);
        price += 25;
        return price;
    }
}
