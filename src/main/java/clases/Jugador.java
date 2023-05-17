package clases;

import java.util.HashSet;

import enums.Gusto;

public class Jugador extends Persona {

	public Jugador(String nombre, int edad, String personalidad, HashSet<Gusto> gustos) {
		super(nombre, edad, personalidad, gustos);
		// TODO Auto-generated constructor stub
	}

	 public static Jugador crearNuevoJugador(String nombre, int edad, String personalidad, HashSet<Gusto> gustos) {
	        return new Jugador(nombre, edad, personalidad, gustos);
	    }

	
	
	
	

}
