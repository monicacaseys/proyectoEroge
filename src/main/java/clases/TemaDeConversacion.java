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
  
    public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList<Pregunta> preguntas) {
		this.preguntas = preguntas;
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
