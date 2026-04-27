import java.lang.constant.Constable;

public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;
    static final int STANDARD_PARCEL_PRICE = 2;
    static final int PERISHABLE_PARCEL_PRICE = 3;
    static final int FRAGILE_PARCEL_PRICE = 4;


    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void setSendDay(int sendDay) {
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + getDescription() +  " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + getDescription() + " доставлена по адресу " +  getDeliveryAddress());
    }

    public int calculateDeliveryCost() {
        return getWeight() * getDeliveryPrice();
    }

    public abstract int getDeliveryPrice();
}
