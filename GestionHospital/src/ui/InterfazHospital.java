package ui;

import domain.GestionHospital;
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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Ventana principal de la aplicación hospitalaria.
 * Captura datos desde la UI y delega la ejecución al servicio de negocio.
 */
public class InterfazHospital extends VentanaConRetorno {

    private final ServicioHospital servicioHospital = new ServicioHospital();
    private final GestionHospital gestionHospital = new GestionHospital();
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
    private JButton btnVolver;
    private JButton btnVerHistorial;
    private JComboBox<String> cbHistorial;
    private final List<String> detalleClientesMedico = new ArrayList<>();

    /**
     * Construye la ventana y conecta los eventos de los botones.
     */
    public InterfazHospital() {
        this(null);
    }

    public InterfazHospital(JFrame ventanaAnterior) {
        super(ventanaAnterior);
        if (panel1 == null || btnSimular == null || btnLimpiar == null || btnVolver == null
                || cbHistorial == null || btnVerHistorial == null) {
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
        setMinimumSize(new Dimension(760, 520));
        setLocationRelativeTo(null);

        btnSimular.addActionListener(e -> ejecutarSimulacion());
        btnLimpiar.addActionListener(e -> txtSalida.setText(""));
        conectarBotonVolver(btnVolver);
        btnVerHistorial.addActionListener(e -> mostrarClienteSeleccionado());
        cbHistorial.addItem("Selecciona un cliente");
        cargarClientesDesdeGestionHospital();

        pack();
    }

    private void mostrarClienteSeleccionado() {
        int indice = cbHistorial.getSelectedIndex();
        if (indice <= 0) {
            return;
        }

        String detalle = detalleClientesMedico.get(indice - 1);
        txtSalida.setText(detalle);
    }

    private void cargarClientesDesdeGestionHospital() {
        detalleClientesMedico.clear();
        List<String> clientes = gestionHospital.getClientesMedicos();
        List<String> detalles = gestionHospital.getDetalleClientesMedicos();

        for (int i = 0; i < clientes.size(); i++) {
            cbHistorial.addItem(clientes.get(i));
            detalleClientesMedico.add(detalles.get(i));
        }
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

        txtSalida.setText(textoResultado);
    }
}
