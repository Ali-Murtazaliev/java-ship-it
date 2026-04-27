import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryAppTests {
    @Test
    public void standardDeliveryCostShouldBeZero(){
        StandardParcel parcel = new StandardParcel("Description", 0,
                "Adress", 1);
        Assertions.assertEquals(0, parcel.calculateDeliveryCost());
    }

    @Test
    public void standardDeliveryCostShouldBe20WhenWeightIs10() {
        StandardParcel parcel = new StandardParcel("Description", 10,
                "Adress", 1);
        Assertions.assertEquals(20, parcel.calculateDeliveryCost());
    }

    @Test
    public void fragileDeliveryCostShouldBeZero(){
        FragileParcel parcel = new FragileParcel("Description", 0,
                "Adress", 1);
        Assertions.assertEquals(0, parcel.calculateDeliveryCost());
    }

    @Test
    public void fragileDeliveryCostShouldBe40WhenWeightIs10(){
        FragileParcel parcel = new FragileParcel("Description", 10,
                "Adress", 1);
        Assertions.assertEquals(40, parcel.calculateDeliveryCost());
    }

    @Test
    public void perishableDeliveryCostShouldBeZero(){
        PerishableParcel parcel = new PerishableParcel("Description", 0,
                "Adress", 1, 3);
        Assertions.assertEquals(0, parcel.calculateDeliveryCost());
    }

    @Test
    public void perishableDeliveryCostShouldBe30WhenWeightIs10(){
        PerishableParcel parcel = new PerishableParcel("Description", 10,
                "Adress", 1, 3);
        Assertions.assertEquals(30, parcel.calculateDeliveryCost());
    }

    @Test
    public void perishableParcelShouldNotBeExpired(){
        int currentDay = 10;
        PerishableParcel parcel = new PerishableParcel("Description", 10,
                "Adress", 8, 10);
        Assertions.assertFalse(parcel.isExpired(currentDay));

    }

    @Test
    public void perishableParcelShouldBeExpired(){
        int currentDay = 20;
        PerishableParcel parcel = new PerishableParcel("Description", 10,
                "Adress", 8, 10);
        Assertions.assertTrue(parcel.isExpired(currentDay));

    }

    @Test
    public void weightShouldBeEnough() {
        ParcelBox<FragileParcel> fragileParcelsBox = new ParcelBox<>(100);
        FragileParcel parcel = new FragileParcel("Description", 50,
                "Adress", 1);
        fragileParcelsBox.addParcel(parcel);
        Assertions.assertEquals(1, fragileParcelsBox.getParcelBox().size());


    }

    @Test
    public void weightShouldBeEnoughIfSame() {
        ParcelBox<FragileParcel> fragileParcelsBox = new ParcelBox<>(100);
        FragileParcel parcel = new FragileParcel("Description", 100,
                "Adress", 1);
        fragileParcelsBox.addParcel(parcel);
        Assertions.assertEquals(1, fragileParcelsBox.getParcelBox().size());

    }

    @Test
    public void weightShouldNotBeEnough() {
        ParcelBox<FragileParcel> fragileParcelsBox = new ParcelBox<>(100);
        FragileParcel parcel = new FragileParcel("Description", 150,
                "Adress", 1);
        fragileParcelsBox.addParcel(parcel);
        Assertions.assertEquals(0, fragileParcelsBox.getParcelBox().size());

    }


}
