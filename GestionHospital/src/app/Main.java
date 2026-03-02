package app;

import ui.MenuPrincipal;

/**
 * Punto de entrada del proyecto.
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        /*
         * SwingUtilities.invokeLater() garantiza que la creación
         * y manipulación de la interfaz gráfica se ejecute en el
         * Event Dispatch Thread (EDT), que es el hilo seguro para
         * trabajar con componentes Swing.
         */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            /**
             * Método run() que contiene el código que se ejecutará
             * dentro del hilo de eventos de Swing.
             */
            @Override
            public void run() {
                MenuPrincipal interfaz = new MenuPrincipal();
                interfaz.setVisible(true);
            }
        });
    }
}
