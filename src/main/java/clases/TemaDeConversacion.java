package clases;

import java.util.ArrayList;

public class TemaDeConversacion {
	private String tema;
	private ArrayList<String> respuesta;
	private byte respuestaCorrecta ;
	
	public TemaDeConversacion(String tema, ArrayList<String> respuesta, byte respuestaCorrecta) {
		super();
		this.tema = tema;
		this.respuesta = respuesta;
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public ArrayList<String> getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(ArrayList<String> respuesta) {
		this.respuesta = respuesta;
	}

	public byte getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(byte respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	@Override
	public String toString() {
		return "TemaDeConversacion [tema=" + tema + ", respuesta=" + respuesta + ", respuestaCorrecta="
				+ respuestaCorrecta + "]";
	}
	
	
	
	

}
