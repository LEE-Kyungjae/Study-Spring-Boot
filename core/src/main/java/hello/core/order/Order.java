package hello.core.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int diccountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int diccountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.diccountPrice = diccountPrice;
    }

    public int calculatePrice() {
        return itemPrice - diccountPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiccountPrice() {
        return diccountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", diccountPrice=" + diccountPrice +
                '}';

    }
}
