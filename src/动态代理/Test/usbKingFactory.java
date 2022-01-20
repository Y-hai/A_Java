package 动态代理.Test;

public class usbKingFactory implements usbSell {
    @Override
    public float sell(int amount) {
        System.out.println("目标类中，执行sell目标方法");
        return 85.0f;
    }
}
