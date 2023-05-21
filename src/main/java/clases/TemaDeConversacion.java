package clases;

import java.util.ArrayList;
import java.util.Random;

public class TemaDeConversacion {
    private ArrayList<Pregunta> preguntas;
    private int indicePreguntaActual;

    public TemaDeConversacion() {
        preguntas = new ArrayList<>();
        indicePreguntaActual = 0;
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }
    //dudo
    public Pregunta obtenerPreguntaAleatoria() {
        if (!preguntas.isEmpty()) {
            Random random = new Random();
            int indiceAleatorio = random.nextInt(preguntas.size());
            return preguntas.get(indiceAleatorio);
        } else {
            return null; // o lanza una excepción o realiza alguna otra acción en caso de que no haya preguntas disponibles
        }
    }

    public Pregunta obtenerPreguntaSiguiente() {
        if (!preguntas.isEmpty()) {
            Pregunta siguientePregunta = preguntas.get(indicePreguntaActual);
            
            // Incrementar el índice de la pregunta actual
            indicePreguntaActual++;
            if (indicePreguntaActual >= preguntas.size()) {
                indicePreguntaActual = 0;
            }
            
            return siguientePregunta;
        } else {
            return null; // o lanza una excepción o realiza alguna otra acción en caso de que no haya preguntas disponibles
        }
    }
    @Override
    public String toString() {
        if (!preguntas.isEmpty()) {
            Pregunta primeraPregunta = preguntas.get(0);
            return primeraPregunta.getEnunciado();
        } else {
            return "Sin preguntas";
        }
    }

}
