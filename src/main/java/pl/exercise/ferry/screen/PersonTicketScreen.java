package pl.exercise.ferry.screen;

import java.util.Scanner;

public class PersonTicketScreen implements Screen {
    final int PRICE_0 = 0;
    final int PRICE_5 = 5;
    final int PRICE_10 = 10;
    Scanner in = new Scanner(System.in);
    PaymentManager paymentManager = new PaymentManager();

    public PersonTicketScreen(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }


    @Override
    public int interact() {
        System.out.println("\nKoszt biletu:");
        System.out.println("do 3 lat: 0 zł");
        System.out.println("od 3 do 18 lat: 5 zł");
        System.out.println("od 18 do 70 lat: 10 zł");
        System.out.println("powyżej 70 lat: 5 zł");

        System.out.print("Wpisz wiek: ");
        int age = in.nextInt();

        if (age < 3) {
            System.out.println("Koszt biletu: 0zł");
            paymentManager.setSaldo(paymentManager.getSaldo() + PRICE_0);
        }
        if (age >= 3 && age < 18) {
            System.out.println("Koszt biletu: 5zł");
            paymentManager.setSaldo(paymentManager.getSaldo() + PRICE_5);
        }
        if (age >= 18 && age < 70) {
            System.out.println("Koszt biletu: 10zł");
            paymentManager.setSaldo(paymentManager.getSaldo() + PRICE_10);
        }
        if (age > 70) {
            System.out.println("Koszt biletu: 5zł");
            paymentManager.setSaldo(paymentManager.getSaldo() + PRICE_5);
        }

        System.out.println("Czy chcesz kupić kolejny bilet? [tak]/[nie]");
        String yesOrNo = in.next();
        if ("tak".equalsIgnoreCase(yesOrNo)) {
            return 1;
        } else {
            System.out.println("Do zapłaty: " + paymentManager.getSaldo());
            return 0;
        }
    }
}
