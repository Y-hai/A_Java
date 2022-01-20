package 动态代理;

public class usbKing implements usbSell {
    @Override
    public float sell(int amount) {
        return 85.0F;
    }
}
