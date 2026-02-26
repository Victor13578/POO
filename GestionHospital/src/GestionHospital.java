import java.util.ArrayList;

/**
 * Clase que gestiona el funcionamiento del hospital.
 * Implementa la interfaz IHospital para iniciar la simulación del sistema.
 * 
 * @author Victor, Juan Sebastian & Sergio Arango 
 * @version 1.0
 */
public class GestionHospital implements IHospital {

    /**
     * Método principal que inicia el día en el hospital.
     * Se crean médicos, cirujanos y pacientes y se ejecutan
     * las acciones principales del sistema.
     */
    @Override
    public void iniciarDia() {

        // crear medico
        Medico m1 = new Medico("Carlos Perez", "1", 40, "M",
                "Cardiologia", 101);

        // crear cirujano
        Cirujano c1 = new Cirujano("Luis Mora", "3", 50, "M",
                "Cirugia", 201, 5, true);

        // crear paciente
        Paciente p1 = new Paciente("Juan", "11", 20, "M",
                "H1", "Sura", 100.0, "infarto");

        // asignar paciente al medico
        m1.agregarPaciente(p1);

        // lista polimorfica
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(m1);
        personas.add(c1);
        personas.add(p1);

        System.out.println("\n--- PRESENTACION ---");

        // polimorfismo
        for (Persona per : personas) {
            per.mostrarDatos();
        }

        // medico revisa pacientes
        m1.revisarPacientes();

        // prioridad
        String prioridad = m1.asignarPrioridad(p1.getSintoma());
        System.out.println("Prioridad asignada: " + prioridad);

        // paciente intenta pagar
        p1.pagarConsulta(50.0);

        // cirujano opera
        c1.realizarOperacion();

        // gestion ingreso
        procesarIngreso(p1);
    }

    /**
     * Procesa el ingreso del paciente al hospital
     * y lo envía a pabellón según su EPS.
     * 
     * @param p paciente que ingresa
     */
    public void procesarIngreso(Paciente p) {

        System.out.println("\nAtención paciente " + p.getNombre());

        if (p.getEps().equalsIgnoreCase("Sura")) {
            System.out.println("Enviado a Pabellón A");
        } else if (p.getEps().equalsIgnoreCase("Sanitas")) {
            System.out.println("Enviado a Pabellón B");
        } else {
            System.out.println("Enviado a Pabellón General");
        }
    }
}
