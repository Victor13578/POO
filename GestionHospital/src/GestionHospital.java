//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class GestionHospital implements IHospital {
    public void iniciarDia() {
        Medico m1 = new Medico("Carlos Perez", "1", 40, "M", "Cardiologia", 101);
        Cirujano c1 = new Cirujano("Luis Mora", "3", 50, "M", "Cirugia", 201, 5, true);
        Paciente p1 = new Paciente("Juan", "11", 20, "M", "H1", "Sura", (double) 100.0F, "infarto");
        m1.agregarPaciente(p1);
        ArrayList<Persona> personas = new ArrayList();
        personas.add(m1);
        personas.add(c1);
        personas.add(p1);

        for (Persona per : personas) {
            per.mostrarDatos();
        }

        m1.revisarPacientes();
        String prioridad = m1.asignarPrioridad(p1.getSintoma());
        System.out.println("Prioridad: " + prioridad);
        p1.pagarConsulta((double) 50.0F);
        c1.realizarOperacion();
        this.procesarIngreso(p1);
    }

    public void procesarIngreso(Paciente p) {
        System.out.println("\nAtención paciente " + p.getNombre());
        if (p.getEps().equalsIgnoreCase("Sura")) {
            System.out.println("Pabellón A");
        } else {
            System.out.println("Pabellón General");
        }

    }
}
