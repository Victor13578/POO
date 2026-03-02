package domain;

import service.ServicioHospital;
import service.SimulacionHospitalRequest;
import service.SimulacionHospitalResultado;

/**
 * Clase que gestiona el funcionamiento del hospital.
 * Implementa la interfaz IHospital para iniciar la simulación del sistema.
 * 
 * @author Victor, Juan Sebastian & Sergio Arango 
 * @version 1.0
 */
public class GestionHospital implements IHospital {

    private final ServicioHospital servicioHospital;

    /**
     * Crea un gestor de hospital con su servicio de aplicación.
     */
    public GestionHospital() {
        this.servicioHospital = new ServicioHospital();
    }

    /**
     * Método principal que inicia el día en el hospital.
     * Se crean médicos, cirujanos y pacientes y se ejecutan
     * las acciones principales del sistema.
     */
    @Override
    public void iniciarDia() {
        SimulacionHospitalRequest request = new SimulacionHospitalRequest(
                "Carlos Perez", "Cardiologia", "Luis Mora",
                "Juan", "Sura", 100.0, "infarto"
        );
        SimulacionHospitalResultado resultado = servicioHospital.ejecutarSimulacion(request);
        System.out.println();
        System.out.println(resultado.comoTexto());
    }

    /**
     * Procesa el ingreso del paciente al hospital
     * y lo envía a pabellón según su EPS.
     * 
     * @param p paciente que ingresa
     */
    public void procesarIngreso(Paciente p) {
        System.out.println();
        System.out.println("Atención paciente " + p.getNombre());
        System.out.println("Enviado a " + servicioHospital.obtenerPabellon(p.getEps()));
    }
}
