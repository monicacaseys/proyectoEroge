package clases;

import java.util.ArrayList;

public class Pesonaje extends Presentacion{

	private int nivelAmor;
	private ArrayList<TemaDeConversacion> respuesta;
	private byte respuestacOrrecta;
	
	public Pesonaje(String nombre, byte edad, String personalidad, String gustos, int nivelAmor,
			ArrayList<TemaDeConversacion> respuesta, byte respuestacOrrecta) {
		super(nombre, edad, personalidad, gustos);
		this.nivelAmor = nivelAmor;
		this.respuesta = respuesta;
		this.respuestacOrrecta = respuestacOrrecta;
	}

	public int getNivelAmor() {
		return nivelAmor;
	}

	public void setNivelAmor(int nivelAmor) {
		this.nivelAmor = nivelAmor;
	}

	public ArrayList<TemaDeConversacion> getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(ArrayList<TemaDeConversacion> respuesta) {
		this.respuesta = respuesta;
	}

	public byte getRespuestacOrrecta() {
		return respuestacOrrecta;
	}

	public void setRespuestacOrrecta(byte respuestacOrrecta) {
		this.respuestacOrrecta = respuestacOrrecta;
	}

	@Override
	public String toString() {
		return "Pesonaje [nivelAmor=" + nivelAmor + ", respuesta=" + respuesta + ", respuestacOrrecta="
				+ respuestacOrrecta + "]";
	}
	
	
	
	
	
}
