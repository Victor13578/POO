package app;

import ui.MenuPrincipal;

public class Main {
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        MenuPrincipal interfaz = new MenuPrincipal();
        interfaz.setVisible(true);
      }
    });
  }
}
