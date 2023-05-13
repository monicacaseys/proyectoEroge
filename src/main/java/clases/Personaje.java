package clases;

import java.util.ArrayList;

public class Personaje extends Presentacion{

	private int nivelAmor;
	private ArrayList<TemaDeConversacion> temasConversacion;
	private ArrayList<Cita> citasDesbloqueadas;
	
	
	public Personaje(String nombre, byte edad, String personalidad, String gustos, int nivelAmor,
			ArrayList<TemaDeConversacion> temasConversacion) {
		super(nombre, edad, personalidad, gustos);
		this.nivelAmor = nivelAmor;
		this.temasConversacion = temasConversacion;
	}

	public int getNivelAmor() {
		return nivelAmor;
	}

	public void setNivelAmor(int nivelAmor) {
		this.nivelAmor = nivelAmor;
	}

	public ArrayList<TemaDeConversacion> getTemasConversacion() {
		return temasConversacion;
	}

	public void setRespuesta(ArrayList<TemaDeConversacion> temasConversacion) {
		this.temasConversacion = temasConversacion;
	}


	
	@Override
	public String toString() {
		return "Pesonaje "+super.toString() +" [nivelAmor=" + nivelAmor + ", temasConversacion=" + temasConversacion + "]";
	}
	
	
	
	
	
}
