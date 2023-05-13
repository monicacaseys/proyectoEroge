package clases;

import java.util.ArrayList;

public class TemaDeConversacion {
	private String tema;
	private ArrayList<String> respuestaPosibles;
	private byte respuestaCorrecta ;
	
	public TemaDeConversacion(String tema, ArrayList<String> respuesta, byte respuestaCorrecta) {
		super();
		this.tema = tema;
		this.respuestaPosibles = respuestaPosibles;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public ArrayList<String> getRespuestaPosibles() {
		return respuestaPosibles;
	}

	public void setRespuesta(ArrayList<String> respuestaPosibles) {
		this.respuestaPosibles = respuestaPosibles;
	}

	public byte getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(byte respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "TemaDeConversacion [tema=" + tema + ", respuestas posibles=" + respuestaPosibles + ", respuestaCorrecta="
				+ respuestaCorrecta + "]";
	}
	
	
	
	

}
