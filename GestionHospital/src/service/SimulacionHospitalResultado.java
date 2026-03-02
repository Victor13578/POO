package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DTO de salida con los eventos generados por una simulación.
 */
public class SimulacionHospitalResultado {

    private final List<String> eventos;

    /**
     * Crea un resultado inmutable a partir de la lista de eventos.
     *
     * @param eventos eventos de la simulación
     */
    public SimulacionHospitalResultado(List<String> eventos) {
        this.eventos = new ArrayList<>(eventos);
    }

    /**
     * @return lista inmodificable de eventos
     */
    public List<String> getEventos()
    {
        return Collections.unmodifiableList(eventos);
    }

    /**
     * @return eventos concatenados en formato texto
     */
    public String comoTexto() {
        return String.join("\n", eventos);
    }
}
