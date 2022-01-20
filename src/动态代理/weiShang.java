package 动态代理;

public class weiShang implements usbSell {
    private usbKing f = new usbKing();

    @Override
    public float sell(int amount) {
        float price = f.sell(amount);
        price += 1;
        return price;
    }
}
