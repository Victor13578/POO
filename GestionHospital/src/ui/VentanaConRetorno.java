package ui;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Comportamiento comun para ventanas secundarias que deben regresar a una ventana anterior.
 */
public abstract class VentanaConRetorno extends JFrame {

    private final JFrame ventanaAnterior;

    protected VentanaConRetorno(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                mostrarVentanaAnterior();
            }
        });
    }

    protected void conectarBotonVolver(AbstractButton botonVolver) {
        botonVolver.addActionListener(e -> cerrarYVolver());
    }

    private void cerrarYVolver() {
        mostrarVentanaAnterior();
        dispose();
    }

    private void mostrarVentanaAnterior() {
        if (ventanaAnterior != null && !ventanaAnterior.isVisible()) {
            ventanaAnterior.setLocationRelativeTo(this);
            ventanaAnterior.setVisible(true);
        }
    }
}
