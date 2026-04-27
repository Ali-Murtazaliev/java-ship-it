import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelsBox = new ParcelBox<>(100);
    private static ParcelBox<FragileParcel> fragileParcelsBox = new ParcelBox<>(200);
    private static ParcelBox<PerishableParcel> perishableParcelsBox = new ParcelBox<>(300);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    getParcelsFromBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Сообщить местоположение посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Какой тип посылки вы хотите отправить?");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
        int newParcelType = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание посылки");
        String newParcelDescription = scanner.nextLine();
        System.out.println("Введите вес посылки");
        int newParcelWeight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес доставки");
        String newParcelAddress = scanner.nextLine();
        System.out.println("День отправки");
        int newParcelSendDay = Integer.parseInt(scanner.nextLine());

        switch (newParcelType) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(newParcelDescription,
                        newParcelWeight, newParcelAddress, newParcelSendDay);
                allParcels.add(standardParcel);
                standardParcelsBox.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(newParcelDescription,
                        newParcelWeight, newParcelAddress, newParcelSendDay);
                allParcels.add(fragileParcel);
                fragileParcelsBox.addParcel(fragileParcel);
                trackableParcels.add(fragileParcel);
                break;
            case 3:
                System.out.println("Введите срок хранения");
                int newParcelTimeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(newParcelDescription,
                        newParcelWeight, newParcelAddress, newParcelSendDay, newParcelTimeToLive);
                allParcels.add(perishableParcel);
                perishableParcelsBox.addParcel(perishableParcel);
                break;
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int allParcelsPrice = 0;
        for (Parcel parcel : allParcels) {
            allParcelsPrice += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки всех посылок - " + allParcelsPrice);

    }

    private static void reportStatus() {
        System.out.println("Введите новое местоположение:");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackableParcels) parcel.reportStatus(newLocation);
    }
    private static void getParcelsFromBox() {
        System.out.println("Какой тип посылок вы хотите посмотреть?");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
        int parcelBoxType = Integer.parseInt(scanner.nextLine());
        switch (parcelBoxType) {
            case 1:
                for (StandardParcel parcel : standardParcelsBox.getParcelBox()){
                    System.out.println(parcel.getDescription());
                }
                break;
            case 2:
                for (FragileParcel parcel : fragileParcelsBox.getParcelBox()){
                    System.out.println(parcel.getDescription());
                }
                break;
            case 3:
                for (PerishableParcel parcel : perishableParcelsBox.getParcelBox()){
                    System.out.println(parcel.getDescription());
                }
                break;
        }

    }
}


