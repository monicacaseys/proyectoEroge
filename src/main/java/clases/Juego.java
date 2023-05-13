package clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Juego {

	private Jugador usuario;
	private ArrayList<Personaje> personajes;
	private int nivelActual;
	private HashMap<Personaje,Integer >nivelAmor;
	
	public Juego(Jugador usuario, ArrayList<Personaje> personajes, int nivelActual,
			HashMap<Personaje, Integer> nivelAmor) {
		super();
		this.usuario = usuario;
		this.personajes = personajes;
		this.nivelActual = nivelActual;
		this.nivelAmor = nivelAmor;
	}

	public Jugador getUsuario() {
		return usuario;
	}

	public void setUsuario(Jugador usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(ArrayList<Personaje> personajes) {
		this.personajes = personajes;
	}

	public int getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}

	public HashMap<Personaje, Integer> getNivelAmor() {
		return nivelAmor;
	}

	public void setNivelAmor(HashMap<Personaje, Integer> nivelAmor) {
		this.nivelAmor = nivelAmor;
	}

	@Override
	public String toString() {
		return "Juego [usuario=" + usuario + ", personajes=" + personajes + ", nivelActual=" + nivelActual
				+ ", nivelAmor=" + nivelAmor + "]";
	}
	
	
	
	
}
