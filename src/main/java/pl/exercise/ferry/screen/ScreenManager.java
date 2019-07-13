package pl.exercise.ferry.screen;

public class ScreenManager {
    PaymentManager paymentManager = new PaymentManager();

    MainScreen mainScreen = new MainScreen(paymentManager);
    TicketScreen ticketScreen = new TicketScreen(paymentManager);
    VehicleTicketScreen vehicleTicketScreen = new VehicleTicketScreen(paymentManager);
    PersonTicketScreen personTicketScreen = new PersonTicketScreen(paymentManager);

    int choosenScreen;

    public void manage() {
        choosenScreen = 0;
        while (true) {
            choosenScreen = chooseScreen(choosenScreen);
        }
    }

    private int chooseScreen(int choosenScreen) {
        if(choosenScreen == 0) {
            return mainScreen.interact();
        }
        if (choosenScreen == 1) {
            return ticketScreen.interact();
        }
        if (choosenScreen == 2) {
            return vehicleTicketScreen.interact();
        }
        if (choosenScreen == 3) {
            return personTicketScreen.interact();
        }
        return mainScreen.interact();
    }

}
