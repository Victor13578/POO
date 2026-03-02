package domain;

import service.ServicioHospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Medico> medicos = Arrays.asList(
                new Medico("Andres Luna", "1001", 45, "M", "Cardiologia", 501),
                new Medico("Laura Mejia", "1002", 39, "F", "Pediatria", 502),
                new Medico("Camilo Rojas", "1003", 41, "M", "Neurologia", 503),
                new Medico("Valentina Torres", "1004", 37, "F", "Medicina Interna", 504)
        );

        List<Cirujano> cirujanos = Arrays.asList(
                new Cirujano("Santiago Perez", "2001", 50, "M", "Cirugia General", 601, 1, true),
                new Cirujano("Paula Gomez", "2002", 46, "F", "Traumatologia", 602, 2, false),
                new Cirujano("Jorge Diaz", "2003", 52, "M", "Neurocirugia", 603, 3, true),
                new Cirujano("Natalia Ruiz", "2004", 44, "F", "Cirugia Vascular", 604, 4, false)
        );

        List<Paciente> pacientes = Arrays.asList(
                new Paciente("Juan Ramirez", "3001", 28, "M", "H001", "Sura", 120.0, "infarto"),
                new Paciente("Maria Lopez", "3002", 33, "F", "H002", "Sanitas", 30.0, "fiebre"),
                new Paciente("Pedro Castillo", "3003", 40, "M", "H003", "Nueva Eps", 75.0, "dolor"),
                new Paciente("Ana Rivera", "3004", 22, "F", "H004", "Sura", 55.0, "fiebre"),
                new Paciente("David Marin", "3005", 61, "M", "H005", "Sanitas", 45.0, "dolor"),
                new Paciente("Sofia Bernal", "3006", 19, "F", "H006", "Nueva Eps", 20.0, "infarto"),
                new Paciente("Lucas Pardo", "3007", 47, "M", "H007", "Sura", 100.0, "dolor"),
                new Paciente("Daniela Soto", "3008", 29, "F", "H008", "Sanitas", 80.0, "fiebre"),
                new Paciente("Mateo Salas", "3009", 35, "M", "H009", "Nueva Eps", 60.0, "dolor"),
                new Paciente("Elena Vidal", "3010", 54, "F", "H010", "Sura", 15.0, "infarto"),
                new Paciente("Tomas Cardenas", "3011", 42, "M", "H011", "Sanitas", 200.0, "fiebre"),
                new Paciente("Isabella Nino", "3012", 31, "F", "H012", "Nueva Eps", 52.0, "dolor")
        );

        for (int i = 0; i < pacientes.size(); i++) {
            Medico medico = medicos.get(i % medicos.size());
            medico.agregarPaciente(pacientes.get(i));
        }

        List<Persona> personas = new ArrayList<>();
        personas.addAll(medicos);
        personas.addAll(cirujanos);
        personas.addAll(pacientes);

        System.out.println("=== PRESENTACION POLIMORFICA ===");
        for (Persona persona : personas) {
            System.out.println(persona.resumenDatos());
        }

        Medico medicoEvaluador = medicos.get(0);
        Paciente pacienteEvaluado = medicoEvaluador.getListaPacientes().get(0);
        System.out.println();
        System.out.println("Pacientes del Dr. " + medicoEvaluador.getNombre() + ":");
        for (Paciente paciente : medicoEvaluador.getListaPacientes()) {
            System.out.println("- " + paciente.getNombre());
        }
        String prioridad = medicoEvaluador.asignarPrioridad(pacienteEvaluado.getSintoma());
        System.out.println("El Dr. " + medicoEvaluador.getNombre() + " evaluó el síntoma "
                + pacienteEvaluado.getSintoma() + " y asignó Prioridad " + prioridad);

        Paciente pacientePago = pacientes.get(0);
        double saldoActual = pacientePago.getSaldoDisponible();
        boolean resultadoPago = pacientePago.pagarConsulta(50.0);
        System.out.println("El paciente " + pacientePago.getNombre() + " intenta pagar $50.0 Saldo actual $"
                + saldoActual + " Resultado " + (resultadoPago ? "Éxito" : "Rechazado"));

        System.out.println();
        for (Cirujano cirujano : cirujanos) {
            boolean operacionRealizada = cirujano.realizarOperacion();
            if (operacionRealizada) {
                System.out.println("El cirujano " + cirujano.getNombre()
                        + " pudo realizar la operacion en quirofano " + cirujano.getNumeroQuirofano());
            } else {
                System.out.println("El cirujano " + cirujano.getNombre()
                        + " no pudo realizar la operacion, quirofano no disponible");
            }
        }

        System.out.println();
        for (Paciente paciente : pacientes) {
            procesarIngreso(paciente);
        }
    }

    /**
     * Procesa el ingreso del paciente al hospital
     * y lo envía a pabellón según su EPS.
     * 
     * @param p paciente que ingresa
     */
    public void procesarIngreso(Paciente p) {
        System.out.println("Paciente " + p.getNombre() + " asignado a " + servicioHospital.obtenerPabellon(p.getEps()));
    }

}
