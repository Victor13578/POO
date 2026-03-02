package domain;

import service.ServicioHospital;

/**
 * Clase encargada de procesar el ingreso de pacientes.
 */
public class Atencion {

    private final ServicioHospital servicioHospital;

    public Atencion() {
        this.servicioHospital = new ServicioHospital();
    }

    public void procesarIngreso(Paciente paciente) {
        String pabellon = servicioHospital.obtenerPabellon(paciente.getEps());
        System.out.println("Paciente " + paciente.getNombre() + " asignado a " + pabellon);
    }
}
