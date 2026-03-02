package app;

import ui.MenuPrincipal;

/**
 * Punto de entrada del proyecto.
 */
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
