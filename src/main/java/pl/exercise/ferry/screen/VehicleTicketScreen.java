package pl.exercise.ferry.screen;

import java.util.Scanner;

public class VehicleTicketScreen implements Screen {
    final int PRICE_20 = 20;
    final int PRICE_10 = 10;
    final int PRICE_5 = 5;
    Scanner in = new Scanner(System.in);
    PaymentManager paymentManager = new PaymentManager();

    public VehicleTicketScreen(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    @Override
    public int interact() {
        System.out.println("\nKoszt biletu:");
        System.out.println("osobowy: 20zł");
        System.out.println("motor: 10zł");
        System.out.println("ciężarówka: 10zł/tona");
        System.out.println("autobus: 5zł/metr");
        System.out.print("Wpisz typ pojazdu: ");
        String answer = in.nextLine();


        if ("osobowy".equalsIgnoreCase(answer)) {
            System.out.println("\nKoszt biletu: 20zł");
            paymentManager.setSaldo(paymentManager.getSaldo() + PRICE_20);
        }
        if ("motor".equalsIgnoreCase(answer)) {
            System.out.println("\nKoszt biletu: 10zł");
            paymentManager.setSaldo(paymentManager.getSaldo() + PRICE_10);

        }
        if ("ciężarówka".equalsIgnoreCase(answer)) {
            System.out.println("\nKoszt biletu: 10zł/tona");
            System.out.print("Podaj wagę poajzdu w tonach: ");
            int weight = in.nextInt();
            int truckTicketPrice = weight * PRICE_10;
            System.out.println("Cena biletu: " + truckTicketPrice);
            paymentManager.setSaldo(paymentManager.getSaldo() + truckTicketPrice);

        }
        if ("autobus".equalsIgnoreCase(answer)) {
            System.out.println("\nKoszt biletu: 5zł/metr");
            System.out.print("Podaj długość poajzdu w metrach: ");
            int lenght = in.nextInt();
            int busTicketPrice = lenght * PRICE_5;
            System.out.println("Cena biletu: " + busTicketPrice);
            paymentManager.setSaldo(paymentManager.getSaldo() + busTicketPrice);
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
