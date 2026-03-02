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
    private final List<Medico> medicos;
    private final List<Cirujano> cirujanos;
    private final List<Paciente> pacientes;

    /**
     * Crea un gestor de hospital con su servicio de aplicación.
     */
    public GestionHospital() {
        this.servicioHospital = new ServicioHospital();
        this.medicos = new ArrayList<>(Arrays.asList(
                new Medico("Felpe Pepe", "1001", 45, "M", "Cardiologia", 501),
                new Medico("Laura Mauricia", "1002", 39, "F", "Pediatria", 502),
                new Medico("Ramón Gus", "1003", 41, "M", "Neurologia", 503),
                new Medico("Juana Iguana", "1004", 37, "F", "Medicina Interna", 504)
        ));

        this.cirujanos = new ArrayList<>(Arrays.asList(
                new Cirujano("Sergio Perio", "2001", 50, "M", "Cirugia General", 601, 1, true),
                new Cirujano("La Booking Punto Com", "2002", 46, "F", "Traumatologia", 602, 2, false),
                new Cirujano("Juanchis Gaynaldo", "2003", 52, "M", "Neurocirugia", 603, 3, true),
                new Cirujano("Gaylor Navas", "2004", 44, "F", "Cirugia Vascular", 604, 4, false)
        ));

        this.pacientes = new ArrayList<>(Arrays.asList(
                new Paciente("Nalgonio", "3001", 28, "M", "H001", "Sura", 120.0, "infarto"),
                new Paciente("Pedo Matedo", "3002", 33, "F", "H002", "Sanitas", 30.0, "fiebre"),
                new Paciente("Herimuerto Palacio", "3003", 40, "M", "H003", "Nueva Eps", 75.0, "dolor"),
                new Paciente("Fran Ksinatra", "3004", 22, "F", "H004", "Sura", 55.0, "fiebre"),
                new Paciente("Alejo Pendejo", "3005", 61, "M", "H005", "Sanitas", 45.0, "dolor"),
                new Paciente("Bernardo Hernando Pernando", "3006", 19, "F", "H006", "Nueva Eps", 20.0, "infarto"),
                new Paciente("Pingo Emilio", "3007", 47, "M", "H007", "Sura", 100.0, "dolor"),
                new Paciente("Juanelio", "3008", 29, "F", "H008", "Sanitas", 80.0, "fiebre"),
                new Paciente("Meo Pateo", "3009", 35, "M", "H009", "Nueva Eps", 60.0, "dolor"),
                new Paciente("Julianio", "3010", 54, "F", "H010", "Sura", 15.0, "infarto"),
                new Paciente("La T-Shirt", "3011", 42, "M", "H011", "Sanitas", 200.0, "fiebre"),
                new Paciente("Gitperius", "3012", 31, "F", "H012", "Nueva Eps", 52.0, "dolor")
        ));

        for (int i = 0; i < pacientes.size(); i++) {
            Medico medico = medicos.get(i % medicos.size());
            medico.agregarPaciente(pacientes.get(i));
        }
    }

    /**
     * Método principal que inicia el día en el hospital.
     * Se crean médicos, cirujanos y pacientes y se ejecutan
     * las acciones principales del sistema.
     */
    @Override
    public void iniciarDia() {
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
     * Obtiene los pacientes creados y asignados a cada médico.
     *
     * @return lista de clientes en formato "Doctor -> Paciente (EPS)"
     */
    public List<String> getClientesMedicos() {
        List<String> clientes = new ArrayList<>();
        for (Medico medico : medicos) {
            for (Paciente paciente : medico.getListaPacientes()) {
                clientes.add("Dr. " + medico.getNombre() + " -> " + paciente.getNombre());
            }
        }
        return clientes;
    }

    /**
     * Obtiene la ficha detallada de cada cliente/paciente asignado.
     *
     * @return lista con fichas completas por paciente
     */
    public List<String> getDetalleClientesMedicos() {
        List<String> detalles = new ArrayList<>();
        for (Medico medico : medicos) {
            for (Paciente paciente : medico.getListaPacientes()) {
                String detalle = "Medico: Dr. " + medico.getNombre()
                        + " | Especialidad: " + medico.especialidad
                        + " | Registro: " + medico.numeroRegistro + "\n"
                        + "Paciente: " + paciente.getNombre()
                        + " | DNI: " + paciente.getDNI()
                        + " | Edad: " + paciente.getEdad()
                        + " | Genero: " + paciente.getGenero() + "\n"
                        + "Historial: " + paciente.getNumeroHistorial()
                        + " | EPS: " + paciente.getEps()
                        + " | Saldo: $" + paciente.getSaldoDisponible()
                        + " | Sintoma: " + paciente.getSintoma();
                detalles.add(detalle);
            }
        }
        return detalles;
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
