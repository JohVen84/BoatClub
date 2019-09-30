import model.Registry;

import java.io.IOException;

public class Program {
  public static void main(String[] args) throws IOException {
    Registry registry = new Registry();
    registry.loadRegistry();
    view.Console view = new view.Console(registry);
    view.displayMainMenu();
  }
}
