public class PerishableParcel extends Parcel {
    private int timeToLive;

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return getSendDay() + getTimeToLive() < currentDay;
    }


    @Override
    public int getDeliveryPrice() {
        return PERISHABLE_PARCEL_PRICE;
    }
}

