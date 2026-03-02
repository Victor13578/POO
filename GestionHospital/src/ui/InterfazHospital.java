package ui;

import service.ServicioHospital;
import service.SimulacionHospitalRequest;
import service.SimulacionHospitalResultado;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Ventana principal de la aplicación hospitalaria.
 * Captura datos desde la UI y delega la ejecución al servicio de negocio.
 */
public class InterfazHospital extends JFrame {

    private final ServicioHospital servicioHospital = new ServicioHospital();
    private JPanel panel1;
    private JTextField txtNombreMedico;
    private JTextField txtEspecialidad;
    private JTextField txtNombreCirujano;
    private JTextField txtNombrePaciente;
    private JTextField txtEps;
    private JTextField txtSintoma;
    private JTextField txtSaldo;
    private JTextArea txtSalida;
    private JButton btnSimular;
    private JButton btnLimpiar;
    private JComboBox<String> cbHistorial;
    private final List<String> resultadosHistorial = new ArrayList<>();

    /**
     * Construye la ventana y conecta los eventos de los botones.
     */
    public InterfazHospital() {
        if (panel1 == null || btnSimular == null || btnLimpiar == null) {
            throw new IllegalStateException("La interfaz debe generarse desde InterfazHospital.form (GUI Designer).");
        }

        JLabel fondo = new JLabel();
        URL rutaImagen = getClass().getResource("/Images/img.png");
        if (rutaImagen != null) {
            fondo.setIcon(new ImageIcon(rutaImagen));
        }
        fondo.setLayout(new BorderLayout());
        panel1.setOpaque(false);
        fondo.add(panel1, BorderLayout.CENTER);
        setContentPane(fondo);
        setTitle("Gestion Hospital - Interfaz");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(760, 520));
        setLocationRelativeTo(null);

        btnSimular.addActionListener(e -> ejecutarSimulacion());
        btnLimpiar.addActionListener(e -> txtSalida.setText(""));
        crearSeccionDesplegable();

        pack();
    }

    private void crearSeccionDesplegable() {
        JPanel panelHistorial = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHistorial.setOpaque(false);

        JLabel lblHistorial = new JLabel("Resultados guardados:");
        cbHistorial = new JComboBox<>();
        cbHistorial.addItem("Selecciona una simulacion");

        JButton btnVer = new JButton("Ver");
        btnVer.addActionListener(e -> mostrarResultadoGuardado());

        panelHistorial.add(lblHistorial);
        panelHistorial.add(cbHistorial);
        panelHistorial.add(btnVer);
        panel1.add(panelHistorial, BorderLayout.SOUTH);
    }

    private void mostrarResultadoGuardado() {
        int indice = cbHistorial.getSelectedIndex();
        if (indice <= 0) {
            return;
        }

        String texto = resultadosHistorial.get(indice - 1);
        txtSalida.setText(texto);
    }

    /**
     * Valida entradas de usuario, ejecuta la simulación y muestra el resultado.
     */
    private void ejecutarSimulacion() {
        String nombreMedico = txtNombreMedico.getText().trim();
        String especialidad = txtEspecialidad.getText().trim();
        String nombreCirujano = txtNombreCirujano.getText().trim();
        String nombrePaciente = txtNombrePaciente.getText().trim();
        String eps = txtEps.getText().trim();
        String sintoma = txtSintoma.getText().trim();

        if (nombreMedico.isEmpty() || especialidad.isEmpty() || nombreCirujano.isEmpty()
                || nombrePaciente.isEmpty() || eps.isEmpty() || sintoma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.", "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        double saldo;
        try {
            saldo = Double.parseDouble(txtSaldo.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El saldo debe ser numerico.", "Valor invalido",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimulacionHospitalRequest request = new SimulacionHospitalRequest(
                nombreMedico, especialidad, nombreCirujano, nombrePaciente, eps, saldo, sintoma
        );
        SimulacionHospitalResultado resultado = servicioHospital.ejecutarSimulacion(request);
        String textoResultado = resultado.comoTexto();

        resultadosHistorial.add(textoResultado);
        cbHistorial.addItem("Simulacion " + resultadosHistorial.size());
        cbHistorial.setSelectedIndex(resultadosHistorial.size());

        txtSalida.setText(textoResultado);
    }
}
