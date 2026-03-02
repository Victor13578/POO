package ui;

import service.ServicioHospital;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazPabellon extends JFrame {

    private final ServicioHospital servicioHospital = new ServicioHospital();
    private final JFrame ventanaAnterior;
    private JPanel panel1;
    private JTextField txtEps;
    private JTextField txtResultado;
    private JButton btnConsultar;
    private JButton btnLimpiar;
    private JButton btnVolver;

    public InterfazPabellon() {
        this(null);
    }

    public InterfazPabellon(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        if (panel1 == null || txtEps == null || txtResultado == null
                || btnConsultar == null || btnLimpiar == null || btnVolver == null) {
            throw new IllegalStateException("La interfaz debe generarse desde InterfazPabellon.form (GUI Designer).");
        }

        setContentPane(panel1);
        setTitle("Consultar pabellon");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(460, 210));
        setLocationRelativeTo(null);

        btnConsultar.addActionListener(e -> consultarPabellon());
        btnLimpiar.addActionListener(e -> {
            txtEps.setText("");
            txtResultado.setText("");
        });
        btnVolver.addActionListener(e -> volverVentanaAnterior());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                mostrarVentanaAnterior();
            }
        });

        pack();
    }

    private void volverVentanaAnterior() {
        mostrarVentanaAnterior();
        dispose();
    }

    private void mostrarVentanaAnterior() {
        if (ventanaAnterior != null && !ventanaAnterior.isVisible()) {
            ventanaAnterior.setLocationRelativeTo(this);
            ventanaAnterior.setVisible(true);
        }
    }

    private void consultarPabellon() {
        String eps = txtEps.getText().trim();

        if (eps.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escribe una EPS.", "Dato faltante", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String pabellon = servicioHospital.obtenerPabellon(eps);
        txtResultado.setText(pabellon);
    }
}
