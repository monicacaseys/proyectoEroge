package clases;

import java.util.ArrayList;

public class Pregunta {

	private String enunciado;
	private ArrayList<String> respuestas;
	private String respuestaCorrecta;
	
	public Pregunta(String enunciado, ArrayList<String> respuestas, String respuestaCorrecta) {
		super();
		this.enunciado = enunciado;
		this.respuestas = respuestas;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public ArrayList<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<String> respuestas) {
		this.respuestas = respuestas;
	}

	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
	
	

}
