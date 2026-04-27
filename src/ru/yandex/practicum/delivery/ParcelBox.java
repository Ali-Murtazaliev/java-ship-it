import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private int maxWeight;
    private List<T> parcelBox = new ArrayList<>();
    private int weight = 0;

    public List<T> getParcelBox() {
        return parcelBox;
    }

    public void setParcelBox(List<T> parcelBox) {
        this.parcelBox = parcelBox;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (weight + parcel.getWeight() > maxWeight) System.out.println("Коробка перегружена.");
        else {
            parcelBox.add(parcel);
            weight = weight + parcel.getWeight();
        }
    }


}
