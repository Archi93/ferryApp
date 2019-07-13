package pl.exercise.ferry;

import pl.exercise.ferry.screen.MainScreen;
import pl.exercise.ferry.screen.ScreenManager;

public class FerryApp {

  public static void main(String[] args) {
    ScreenManager screenManager = new ScreenManager();

    screenManager.manage();

  }
}
