package clases;

import java.util.ArrayList;

public class TemaDeConversacion {
    private ArrayList<Pregunta> preguntas;

    public TemaDeConversacion() {
        preguntas = new ArrayList<>();
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }
}
