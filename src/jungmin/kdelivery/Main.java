package jungmin.kdelivery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KDeliveryMain kDelivery =
                new KDeliveryMain(new Scanner(System.in));

        int selectedMenuNumber;
        do {
            selectedMenuNumber = kDelivery.selectMainMenu();
            switch (selectedMenuNumber) {
                case 1: {
                    kDelivery.selectAddShopMenu();
                    break;
                }
                case 2: {
                    kDelivery.selectDashboardMenu();
                    break;
                }
                case 3: {
                    kDelivery.selectOrderMenu();
                    break;
                }
                case 4: {
                    kDelivery.selectFeedbackMenu();
                    break;
                }
                case 5: {
                    kDelivery.addShopInMenu();
                }
            }
        } while(selectedMenuNumber != 6);

        kDelivery.close();
        System.out.println("[안내] 이용해주셔서 감사합니다.");
    }
}
