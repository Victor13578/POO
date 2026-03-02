package service;

import domain.Cirujano;
import domain.Medico;
import domain.Paciente;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de aplicación que orquesta el caso de uso principal del hospital.
 */
public class ServicioHospital {

    /**
     * Ejecuta una simulación completa del flujo del hospital.
     *
     * @param request datos de entrada de la simulación
     * @return resultado con eventos listos para presentar
     */
    public SimulacionHospitalResultado ejecutarSimulacion(SimulacionHospitalRequest request) {
        Medico medico = new Medico(request.getNombreMedico(), "1", 40, "M",
                request.getEspecialidad(), 101);

        Cirujano cirujano = new Cirujano(request.getNombreCirujano(), "3", 50, "M",
                "Cirugia", 201, 5, true);

        Paciente paciente = new Paciente(request.getNombrePaciente(), "11", 20, "M",
                "H1", request.getEps(), request.getSaldo(), request.getSintoma());

        medico.agregarPaciente(paciente);

        List<String> eventos = new ArrayList<>();
        eventos.add("--- PRESENTACION ---");
        eventos.add(medico.resumenDatos());
        eventos.add(cirujano.resumenDatos());
        eventos.add(paciente.resumenDatos());
        eventos.add("");

        eventos.add("Dr. " + medico.getNombre() + " revisando pacientes:");
        for (Paciente p : medico.getListaPacientes()) {
            eventos.add("- " + p.getNombre());
        }

        String prioridad = medico.asignarPrioridad(paciente.getSintoma());
        eventos.add("Prioridad asignada: " + prioridad);

        double saldoAntes = paciente.getSaldoDisponible();
        boolean pagoExitoso = paciente.pagarConsulta(50.0);
        eventos.add("El paciente " + paciente.getNombre() + " intenta pagar $50.0. Saldo actual $"
                + saldoAntes + " Resultado: " + (pagoExitoso ? "Éxito" : "Rechazado"));

        boolean operacionRealizada = cirujano.realizarOperacion();
        if (operacionRealizada) {
            eventos.add("El cirujano " + cirujano.getNombre() +
                    " realizó operación en quirófano " + cirujano.getNumeroQuirofano());
        } else {
            eventos.add("El cirujano " + cirujano.getNombre() +
                    " NO pudo operar. Quirófano ocupado.");
        }

        eventos.add("");
        eventos.add("Atención paciente " + paciente.getNombre());
        eventos.add("Enviado a " + obtenerPabellon(paciente.getEps()));

        return new SimulacionHospitalResultado(eventos);
    }

    /**
     * Determina el pabellón destino según la EPS del paciente.
     *
     * @param eps entidad de salud del paciente
     * @return pabellón correspondiente
     */
    public String obtenerPabellon(String eps) {
        if (eps == null) {
            return "Pabellón General";
        }

        if (eps.equalsIgnoreCase("Sura")) {
            return "Pabellón A";
        }

        if (eps.equalsIgnoreCase("Sanitas")) {
            return "Pabellón B";
        }

        return "Pabellón General";
    }
}
