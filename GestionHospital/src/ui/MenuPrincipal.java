package ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;

public class MenuPrincipal extends JFrame {

    private JPanel panel1;
    private JComboBox<String> cbOpciones;
    private JButton btnAbrir;

    public MenuPrincipal() {
        if (panel1 == null || cbOpciones == null || btnAbrir == null) {
            throw new IllegalStateException("La interfaz debe generarse desde MenuPrincipal.form (GUI Designer).");
        }

        setContentPane(panel1);
        setTitle("Menu principal");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(420, 220));
        setLocationRelativeTo(null);

        btnAbrir.addActionListener(e -> abrirOpcion());

        pack();
    }

    private void abrirOpcion() {
        String opcion = (String) cbOpciones.getSelectedItem();

        if ("Simulacion hospital".equals(opcion)) {
            InterfazHospital ventana = new InterfazHospital();
            ventana.setVisible(true);
            return;
        }

        if ("Consultar pabellon por EPS".equals(opcion)) {
            InterfazPabellon ventana = new InterfazPabellon();
            ventana.setVisible(true);
        }
    }
}
