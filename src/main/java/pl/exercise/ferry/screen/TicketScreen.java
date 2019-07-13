package pl.exercise.ferry.screen;

import java.util.Scanner;

public class TicketScreen implements Screen {
    PaymentManager paymentManager;


    Scanner in = new Scanner(System.in);

    public TicketScreen(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }


    public int interact() {
        System.out.println("\nTwoje saldo: " + paymentManager.getSaldo());
        System.out.println("Jaki bilet chcesz kupić?\n[osoba]\n[pojazd]\n[towar]");
        String answer = in.nextLine();
        if("osoba".equalsIgnoreCase(answer)) {
            return 3;
        }
        if("pojazd".equalsIgnoreCase(answer)) {
            return 2;
        }
        if("towar".equalsIgnoreCase(answer)) {
            return 4;
        }

        return 0;
    }
}
