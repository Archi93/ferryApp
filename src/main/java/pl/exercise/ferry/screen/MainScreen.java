package pl.exercise.ferry.screen;


import java.util.Scanner;

public class MainScreen implements Screen {
    PaymentManager paymentManager;


    private final Scanner in = new Scanner(System.in);

    public MainScreen(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public int interact() {
        System.out.println("\nWitaj, czy chcesz kupić bilet? [tak]/[nie]");
        String answer = in.nextLine();
        if("tak".equals(answer)){
            paymentManager.setSaldo(0);
            return 1;
        }
        return 0;
    }
}

