public class StandardParcel extends Parcel{
    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }
    static final int STANDARD_PARCEL_PRICE = 2;


    @Override
    public int getDeliveryPrice() {
        return STANDARD_PARCEL_PRICE;
    }
}
