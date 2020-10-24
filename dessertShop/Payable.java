package dessertShop;

public interface Payable {

    //attributes
    enum PayType{
        CASH,
        CARD,
        PHONE
    }
    //methods
    PayType getPayType();
    PayType setPayType(PayType payment);
}
