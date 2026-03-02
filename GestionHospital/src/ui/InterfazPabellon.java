package ui;

import service.ServicioHospital;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class InterfazPabellon extends JFrame {

    private final ServicioHospital servicioHospital = new ServicioHospital();
    private JPanel panel1;
    private JTextField txtEps;
    private JTextField txtResultado;
    private JButton btnConsultar;
    private JButton btnLimpiar;

    public InterfazPabellon() {
        if (panel1 == null || txtEps == null || txtResultado == null || btnConsultar == null || btnLimpiar == null) {
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

        pack();
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
